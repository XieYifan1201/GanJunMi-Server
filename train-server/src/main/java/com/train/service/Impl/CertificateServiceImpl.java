package com.train.service.Impl;

import com.train.context.BaseContext;
import com.train.dto.CertificateDTO;
import com.train.dto.StudentIdsDTO;
import com.train.dto.UserPageQueryDTO;
import com.train.entity.*;
import com.train.exception.BaseException;
import com.train.mapper.*;
import com.train.result.PageResult;
import com.train.service.CertificateService;
import com.train.vo.CertificateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;
    @Autowired
    private StudentCertificateMapper studentCertificateMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TrainsClassMapper trainsClassMapper;
    @Autowired
    private TrainSInfoMapper trainSInfoMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    @Override
    public CertificateVO getByNumber(String number) {
        StudentCertificate sc = studentCertificateMapper.getByCertificateNo(number);
        if (sc == null){
            throw new BaseException("证书不存在");
        }
        Student student = studentMapper.getById(sc.getStudentId());
        TrainsClass trainsClass = trainsClassMapper.getById(sc.getTrainsClassId());
        Certificate certificate = certificateMapper.getById(sc.getCertificateId());
        TrainsInfo trainsInfo = trainSInfoMapper.getById(certificate.getTrainsInfoId());
        return CertificateVO.builder()
                .CertificateNo(sc.getCertificateNo()).title(certificate.getTitle())
                .startDate(certificate.getStartDate()).endDate(certificate.getEndDate())
                .trainUnit(certificate.getTrainUnit()).name(student.getName())
                .QRcode(sc.getQRcode()).image(student.getImage())
                .trainStartDate(trainsClass.getStartDate()).trainEndDate(trainsClass.getEndDate())
                .trainsTitle(trainsInfo.getTrainsTitle()).trainsHour(trainsInfo.getTrainsHour()).build();
    }

    /**
     * 添加证书
     * @param certificateDTO
     */
    @Transactional
    public void save(CertificateDTO certificateDTO) {

    }

    /**
     * 分页查询
     * @param pageQueryDTO
     */
    @Override
    public PageResult pageQuery(UserPageQueryDTO pageQueryDTO) {
        Integer roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId < 3){
            /*
            //身份证信息隐藏
            for (CertificateVO certificateVO : page) {
                String idCard = certificateVO.getIdCard();
                if (idCard != null && idCard.length() == 18){
                    certificateVO.setIdCard(idCard.substring(0,14)+ "****");
                }
            }
             */
            return null;
        }else {
            throw new BaseException("权限不足");
        }
    }

    /**
     * 修改证书
     * @param certificateDTO
     */
    @Transactional
    public void update(CertificateDTO certificateDTO) {
        Integer roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId < 3){
            /*
            //将usersCertificate的数据修改
            UsersCertificate usersCertificate = new UsersCertificate();
            BeanUtils.copyProperties(certificateDTO,usersCertificate);
            userCertificateMapper.update(usersCertificate);
            //将certificate的数据修改
            int certificateId = userCertificateMapper.getById(certificateDTO.getId()).getCertificateId();

            Certificate certificate = new Certificate();
            BeanUtils.copyProperties(certificateDTO,certificate);
            certificate.setId(certificateId);
            //certificate.setStartdate(LocalDateTime.of(certificateDTO.getStartdate(), LocalTime.MIN));
            certificateMapper.update(certificate);
             */
        }else {
            throw new BaseException("权限不足");
        }
    }

    /**
     * 删除证书
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        Integer roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId < 3){
        }else {
            throw new BaseException("权限不足");
        }
    }

    //判断字符串合法性判断
    public static boolean isNumber(String number,String regex) {
        if (number == null) {
            return false;
        }
        return number.matches(regex);
    }

}
