package com.train.service.Impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.train.context.BaseContext;
import com.train.dto.*;
import com.train.entity.*;
import com.train.exception.BaseException;
import com.train.mapper.*;
import com.train.result.PageResult;
import com.train.service.StudentService;
import com.train.vo.CertificateVO;
import com.train.vo.SignInfo;
import com.train.vo.SignVO;
import com.train.vo.StudentInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${web.upload-path}")
    String path;    //图片保存路径

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCertificateMapper studentCertificateMapper;
    @Autowired
    private TrainsClassMapper trainsClassMapper;
    @Autowired
    private CertificateMapper certificateMapper;
    @Autowired
    private TrainSInfoMapper trainSInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;

    /**
     * 学员报名
     * @param signDTO
     */
    @Transactional
    public void sign(SignDTO signDTO,String imgPath) {
        //身份证号合法性
        if (signDTO.getIdCard() != null && !isNumber(signDTO.getIdCard(), "^(\\d{17})([0-9]|X|x)$")) {
            throw new BaseException("身份证号格式不正确");
        }
        Student s = studentMapper.getByIdCard(signDTO.getIdCard());
        if (s != null){
            //已有学员信息，修改信息
            BeanUtils.copyProperties(signDTO,s);
            studentMapper.update(s);
            //一期只能报名一个班次，判断是否报名同期班次

            //获取这人的所有报名记录
            List<StudentCertificate> scInfo = studentCertificateMapper.getByStudentId(s.getId());
            if (scInfo.size() > 0){
                //先获取当前报名的同期培训的班次id
                List<Integer> ids = trainsClassMapper.getIds(signDTO.getTrainClassId());
                //已有报名记录，判断是否报名同期班次
                for (StudentCertificate studentCertificate : scInfo) {
                    if (ids.contains(studentCertificate.getTrainsClassId())){
                        throw new BaseException("该学员已报名同期培训，不可再次报名");
                    }
                }
            }
        }else {
            //没有学员信息，先添加学员信息
            s = new Student();
            BeanUtils.copyProperties(signDTO,s);
            studentMapper.add(s);
        }
        //生成证书编号
        String ID = "GGJM791";
        //通过培训期数次id获取年份、期号
        String trainsName = trainSInfoMapper.getById(signDTO.getTrainsId()).getTrainsName();
        // 通过班次id获取班次
        TrainsClass classInfo = trainsClassMapper.getById(signDTO.getTrainClassId());
        String trainsClassName = classInfo.getTrainsClassName();
        //将获取的数据格式化
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(trainsName);    //2024年第6期
        matcher.find();
        String year = matcher.group();  //2024
        matcher.find();
        String qi = matcher.group();    //6
        matcher = pattern.matcher(trainsClassName);     //第3班次
        matcher.find();
        String ban = matcher.group();   //3
        year = addZeroForNum(year,4);
        qi = addZeroForNum(qi,2);
        ban = addZeroForNum(ban,2);
        //获取序列号
        int count = classInfo.getCount();
        count += 1;
        //修改数据库中count信息
        trainsClassMapper.setCount(signDTO.getTrainClassId(),count);
        ID = ID + year + qi + ban + addZeroForNum( count + "",4);

        //获取期次的证书信息
        Certificate certificate = certificateMapper.getCertificate(signDTO.getTrainsId());
        //将证书编号转换为二维码保存
        String fileName = ID + ".png";
        /*
        QrCodeUtil.generate("http://shiptrains.jvtc.jx.cn/#/pages/query?id=" + ID,
                200,200, FileUtil.file(path+"/qrcode/" + fileName));
         */
        QrConfig qrConfig = new QrConfig(200,200);
        // 设置边距，既二维码和背景之间的边距
        qrConfig.setMargin(0);
        QrCodeUtil.generate("http://shiptrains.jvtc.jx.cn/#/pages/query?id=" + ID,qrConfig,
                FileUtil.file(path+"/qrcode/" + fileName));



        StudentCertificate sCertificate = StudentCertificate.builder()
                .studentId(s.getId()).trainsClassId(signDTO.getTrainClassId())
                .isCertificate(false).CertificateNo(ID).certificateId(certificate.getId())
                .QRcode(imgPath+fileName).build();
        studentCertificateMapper.save(sCertificate);

    }

    /**
     * 添加学员信息
     * @param student
     */
    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    /**
     * 根据id查询学员信息
     * @param id
     * @return
     */
    @Override
    public Student getById(Long id) {
        Student student = studentMapper.getById(id);
        return student;
    }

    /**
     * 修改学员信息
     * @param student
     */
    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    /**
     * 删除学员信息
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        if (studentCertificateMapper.getCertificateCount(id) > 0){
            throw new BaseException("该学员已有证书信息，不可删除");
        }
        Student student = studentMapper.getById(id);
        if (student != null){
            if (student.getInvoiceId() != null){
                invoiceMapper.deleteInvoice(student.getInvoiceId());
            }
            studentCertificateMapper.deleteByStudentId(id);
            studentMapper.delete(id);
        }else {
            throw new BaseException("该学员不存在");
        }
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult getByBatch(StudentPageQueryDTO pageQueryDTO) {
        if (pageQueryDTO.getTrainsId() == 0){
            //没用传递，在studentinfo中查询
            PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
            Page<Student> page = studentMapper.getByBatch(pageQueryDTO);
            return new PageResult(page.getTotal(),page.getResult());
        }else {
            //传递了，在studentcertificate中查询
            //先查询班次id
            List<Integer> classIds = trainsClassMapper.getIdByTrainsId(pageQueryDTO.getTrainsId());
            PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
            Page<Student> page = studentCertificateMapper.getStudentBatch(classIds,pageQueryDTO.getName(),pageQueryDTO.getSex(),
                    pageQueryDTO.getWorkUnit(),pageQueryDTO.getIdCard());
            return new PageResult(page.getTotal(),page.getResult());
        }

    }

    /**
     * 分页查询学员信息(包含发票信息)
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult getByBatch1(StudentInvoicePageQueryDTO pageQueryDTO) {
        if (pageQueryDTO.getTrainsId() == 0){
            //没用传递，在studentinfo中查询
            PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
            Page<StudentInfoVo> page = studentMapper.getByBatch1(pageQueryDTO.getName(),pageQueryDTO.getState());
            return new PageResult(page.getTotal(),page.getResult());
        }else {
            //传递了，在studentcertificate中查询
            //先查询班次id
            List<Integer> classIds = trainsClassMapper.getIdByTrainsId(pageQueryDTO.getTrainsId());
            PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
            Page<StudentInfoVo> page = studentCertificateMapper.getStudentBatch1(classIds,pageQueryDTO.getName(),pageQueryDTO.getState());
            return new PageResult(page.getTotal(),page.getResult());
        }
    }

    /**
     * 获取学员报名信息
     * @return
     */
    @Override
    public SignVO signInfo() {
        User user = userMapper.getById(BaseContext.getCurrentId());
        String idCard = user.getIdCard();
        if (idCard != null && idCard.length() == 18){
            SignVO signVO = new SignVO();
            //获取报名学员信息
            Student student = studentMapper.getByIdCard(idCard);
            BeanUtils.copyProperties(student,signVO);
            signVO.setStudentId(student.getId());
            //获取报名信息
            List<StudentCertificate> certificates = studentCertificateMapper.getByStudentId(student.getId());
            List<SignInfo> signInfos = new ArrayList<>();
            certificates.forEach(sc -> {
                SignInfo signInfo = new SignInfo();
                signInfo.setCertificate(sc.isCertificate());
                signInfo.setCertificateNo(sc.getCertificateNo());
                TrainsClass trainsClass = trainsClassMapper.getById(sc.getTrainsClassId());
                signInfo.setStartDate(trainsClass.getStartDate());
                signInfo.setEndDate(trainsClass.getEndDate());
                signInfo.setTrainsClassName(trainsClass.getTrainsClassName());
                TrainsInfo trainsInfo = trainSInfoMapper.getById(trainsClass.getTrainsInfoId());
                signInfo.setTrainsTitle(trainsInfo.getTrainsTitle());
                signInfo.setTrainsName(trainsInfo.getTrainsName());
                signInfos.add(signInfo);
            });
            signVO.setSignInfos(signInfos);
            return signVO;
        }else {
            throw new BaseException("请先完善您的个人信息");
        }
    }

    /**
     * 获取证书信息
     * @param studentIdsDTO
     * @return
     */
    @Override
    public List<CertificateVO> getCertificate(StudentIdsDTO studentIdsDTO) {
        List<Integer> ids = studentIdsDTO.getIds();
        if (ids.size() > 0){
            //将证书状态进行修改
            studentCertificateMapper.updateCertificate(ids);
            //获取信息并进行封装
            //studentCertificate
            List<StudentCertificate> sCertificate = studentCertificateMapper.getById(ids);
            List<CertificateVO> list = new ArrayList<>();
            sCertificate.forEach(sc -> {
                Student student = studentMapper.getById(sc.getStudentId());
                TrainsClass trainsClass = trainsClassMapper.getById(sc.getTrainsClassId());
                Certificate certificate = certificateMapper.getById(sc.getCertificateId());
                TrainsInfo trainsInfo = trainSInfoMapper.getById(certificate.getTrainsInfoId());
                CertificateVO certificateVO = CertificateVO.builder()
                        .CertificateNo(sc.getCertificateNo()).title(certificate.getTitle())
                        .startDate(certificate.getStartDate()).endDate(certificate.getEndDate())
                        .trainUnit(certificate.getTrainUnit()).name(student.getName())
                        .QRcode(sc.getQRcode()).image(student.getImage())
                        .trainStartDate(trainsClass.getStartDate()).trainEndDate(trainsClass.getEndDate())
                        .trainsTitle(trainsInfo.getTrainsTitle()).trainsHour(trainsInfo.getTrainsHour()).build();
                list.add(certificateVO);
            });
            return list;

        }
        return null;
    }

    //判断字符串合法性判断
    public static boolean isNumber(String number,String regex) {
        if (number == null) {
            return false;
        }
        return number.matches(regex);
    }

    //字符长度不足补0
    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            strLength = strLength - strLen;
            for (int i = 0; i < strLength; i++) {
                str = "0" + str;
            }
        }
        return str;
    }
}
