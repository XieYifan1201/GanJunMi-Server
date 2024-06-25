package com.train.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.train.context.BaseContext;
import com.train.dto.CertificateDTO;
import com.train.dto.UserPageQueryDTO;
import com.train.entity.Certificate;
import com.train.entity.UsersCertificate;
import com.train.exception.BaseException;
import com.train.mapper.CertificateMapper;
import com.train.mapper.UserCertificateMapper;
import com.train.mapper.UserMapper;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.CertificateService;
import com.train.vo.CertificateVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Slf4j
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private UserCertificateMapper userCertificateMapper;
    @Autowired
    private CertificateMapper certificateMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    @Override
    public CertificateVO getByNumber(String number) {
        CertificateVO certificateVO = userCertificateMapper.getByNumber(number);
        if (certificateVO == null){
            throw new BaseException("未查到此证书");
        }
        //certificateVO.setIdCard(certificateVO.getIdCard().substring(0,14)+"****");

        return certificateVO;
    }

    /**
     * 添加证书
     * @param certificateDTO
     */
    @Transactional
    public void save(CertificateDTO certificateDTO) {
        Integer roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId < 3){
            //身份证号合法性
            if (!isNumber(certificateDTO.getIdCard(),"^(\\d{17})([0-9]|X|x)$") || certificateDTO.getStartdate() == null || certificateDTO.getImage() == null){
                throw new BaseException("输入数据格式不正确");
            }


            //将certificate的数据添加
            Certificate certificate = new Certificate();
            BeanUtils.copyProperties(certificateDTO,certificate);
            certificate.setStartdate(LocalDateTime.of(certificateDTO.getStartdate(), LocalTime.MIN));
            certificateMapper.save(certificate);
            //将usersCertificate的数据添加
            UsersCertificate usersCertificate = new UsersCertificate();
            BeanUtils.copyProperties(certificateDTO,usersCertificate);
            usersCertificate.setCertificateId(certificate.getId());
            userCertificateMapper.save(usersCertificate);
        }else{
            throw new BaseException("权限不足");
        }
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     */
    @Override
    public PageResult pageQuery(UserPageQueryDTO pageQueryDTO) {
        Integer roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId < 3){
            PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
            Page<CertificateVO> page = userCertificateMapper.pageQuery(pageQueryDTO.getName());
            /*
            //身份证信息隐藏
            for (CertificateVO certificateVO : page) {
                String idCard = certificateVO.getIdCard();
                if (idCard != null && idCard.length() == 18){
                    certificateVO.setIdCard(idCard.substring(0,14)+ "****");
                }
            }
             */
            return new PageResult(page.getTotal(),page.getResult());
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
            //将usersCertificate的数据修改
            UsersCertificate usersCertificate = new UsersCertificate();
            BeanUtils.copyProperties(certificateDTO,usersCertificate);
            userCertificateMapper.update(usersCertificate);
            //将certificate的数据修改
            Long certificateId = userCertificateMapper.getById(certificateDTO.getId()).getCertificateId();

            Certificate certificate = new Certificate();
            BeanUtils.copyProperties(certificateDTO,certificate);
            certificate.setId(certificateId);
            certificate.setStartdate(LocalDateTime.of(certificateDTO.getStartdate(), LocalTime.MIN));
            certificateMapper.update(certificate);
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
            //删除certificate表信息
            Long certificateId = userCertificateMapper.getById(id).getCertificateId();      //certificate id
            certificateMapper.delete(certificateId);
            //删除userscertificate表信息
            userCertificateMapper.delete(id);
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
