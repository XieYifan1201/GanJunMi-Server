package com.train.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.train.dto.*;
import com.train.entity.Certificate;
import com.train.entity.Student;
import com.train.entity.TrainsClass;
import com.train.entity.TrainsInfo;
import com.train.exception.BaseException;
import com.train.mapper.CertificateMapper;
import com.train.mapper.StudentCertificateMapper;
import com.train.mapper.TrainSInfoMapper;
import com.train.mapper.TrainsClassMapper;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.ClassesService;
import com.train.vo.ClassesVO;
import com.train.vo.StudentVO;
import com.train.vo.TrainsClassVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private TrainSInfoMapper trainSInfoMapper;
    @Autowired
    private TrainsClassMapper trainsClassMapper;
    @Autowired
    private CertificateMapper certificateMapper;
    @Autowired
    private StudentCertificateMapper studentCertificateMapper;

    /**
     * 添加开班信息
     * @param trainsInfoDTO
     */
    @Override
    @Transactional
    public void addClasses(TrainsInfoDTO trainsInfoDTO) {
        try {
            String trainsName = trainsInfoDTO.getTrainsName();
            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(trainsName);    //2024年第6期
            matcher.find();
            matcher.group();  //2024
            matcher.find();
            matcher.group();    //6
        }catch (Exception exception){
            throw new BaseException("开班期数命名请按照：xxxx年第x期的格式（x为数字）");
        }
        //先添加TrainSInfo信息
        TrainsInfo trainsInfo = new TrainsInfo();
        BeanUtils.copyProperties(trainsInfoDTO,trainsInfo);
        trainSInfoMapper.add(trainsInfo);
        /*
        trainsInfoDTO.getClassInfo().forEach(trainsClass -> {
            trainsClass.setTrainsInfoId(trainsInfo.getTrainsId());
        });

        //添加trainClass信息
        trainsClassMapper.add(trainsInfoDTO.getClassInfo());
         */

        //添加空的证书信息（还需要再次管理员手动添加）
        certificateMapper.save(CertificateDTO.builder().trainsInfoId(trainsInfo.getTrainsId()).build());

    }

    /**
     * 添加班次信息
     * @param trainsClassDTO
     */
    @Transactional
    public void addClass(TrainsClassDTO trainsClassDTO) {
        try {
            String trainsClassName = trainsClassDTO.getTrainsClassName();
            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(trainsClassName);     //第3班次
            matcher.find();
            matcher.group();   //3
        }catch (Exception e){
            throw new BaseException("培训班次命名请按照：第xx班次的格式（x为数字）");
        }
        trainsClassMapper.add(trainsClassDTO);
        int count = trainSInfoMapper.getCount(trainsClassDTO.getTrainsInfoId());
        count += 1;
        trainSInfoMapper.updateCount(trainsClassDTO.getTrainsInfoId(),count);
    }

    /**
     * 删除开班信息(谨慎使用！！！)
     * @param id
     */
    @Transactional
    public void delete(int id) {
        //删除TrainsClass信息
        trainsClassMapper.delete(id);
        //删除TrainSInfo信息
        trainSInfoMapper.delete(id);
        //删除删除证书信息
        certificateMapper.deleteByTrainsInfoId(id);
    }

    /**
     * 删除班次信息
     * @param id
     */
    @Transactional
    public void deleteByTrainsClassId(int id) {
        int trainsId = trainsClassMapper.getTrainsId(id);
        trainsClassMapper.deleteById(id);
        int count = trainSInfoMapper.getCount(trainsId);
        count -= 1;
        trainSInfoMapper.updateCount(trainsId,count);
    }

    /**
     * 修改培训期数信息
     * @param trainsInfoDTO
     */
    @Override
    public void updateClasses(TrainsInfoDTO trainsInfoDTO) {
        TrainsInfo trainsInfo = new TrainsInfo();
        BeanUtils.copyProperties(trainsInfoDTO,trainsInfo);
        trainSInfoMapper.update(trainsInfo);
        /*
        //删除原来的班次信息
        trainsClassMapper.delete(trainsInfo.getTrainsId());

        trainsInfoDTO.getClassInfo().forEach(trainsClass -> {
            trainsClass.setTrainsInfoId(trainsInfo.getTrainsId());
        });

        //添加trainClass信息
        trainsClassMapper.add(trainsInfoDTO.getClassInfo());
         */
    }

    /**
     * 修改班次信息
     * @param trainsClass
     */
    @Override
    public void updateClass(TrainsClassDTO1 trainsClass) {
        trainsClassMapper.update(trainsClass);

    }

    /**
     * 分页查询期数信息
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult getByBatch(ClassesPageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<TrainsInfo> page = trainSInfoMapper.pageQuery(pageQueryDTO.getName(),pageQueryDTO.getState());
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据期数id获取班次信息
     * @param id
     * @return
     */
    @Override
    public List<TrainsClassVO> getByTrainsId(int id) {
        return trainsClassMapper.getByTrainsId(id);
    }


    /**
     * 设置是否允许报名
     * @param id
     * @param isStart
     */
    @Override
    public void setStart(int id, boolean isStart) {
        trainSInfoMapper.setStart(id,isStart);
    }

    /**
     * 给这期培训添加/修改证书信息
     * @param certificateDTO
     */
    @Override
    public void save(CertificateDTO certificateDTO) {
        Certificate certificate = certificateMapper.getCertificate(certificateDTO.getTrainsInfoId());
        if (certificateDTO.getTitle() == null || certificateDTO.getTitle().length() == 0){
            certificateDTO.setTitle("江西省军工保密培训证书");
        }
        if (certificateDTO.getTrainUnit() == null || certificateDTO.getTrainUnit().length() == 0){
            certificateDTO.setTrainUnit("江西省国防科学技术工业办公室");
        }
        if (certificate == null){
            //添加
            certificateMapper.save(certificateDTO);
        }else{
            //修改
            certificateMapper.update(certificateDTO);
        }
    }

    /**
     * 获取报名班次的学员信息
     * @param pageQueryDTO
     */
    @Override
    public PageResult getStudentByTrainsClassId(StudentByClassDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<StudentVO> page = studentCertificateMapper.getByTrainsClassId(pageQueryDTO.getTrainsClassId(),pageQueryDTO.getName());
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据期数id获取证书信息
     * @param trainsInfoId
     * @return
     */
    @Override
    public Certificate getCertificate(int trainsInfoId) {
        return certificateMapper.getCertificate(trainsInfoId);
    }

    /**
     * 获取报名班级的总人数
     * @return
     */
    @Override
    public Integer getClassCount(int trainsClassId) {
        return studentCertificateMapper.getClassCount(trainsClassId);
    }

    /**
     * 管理员取消学员报名
     * @param studentCertificateId
     */
    @Override
    public void deleteByStudentCertificate(int studentCertificateId) {
        studentCertificateMapper.deleteById(studentCertificateId);
    }

    /**
     * 分页获取班次信息
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult getClassInfo(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<ClassesVO> page = trainsClassMapper.getClassInfo(pageQueryDTO.getName());
        return new PageResult(page.getTotal(),page.getResult());
    }
}
