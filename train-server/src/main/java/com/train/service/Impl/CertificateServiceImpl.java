package com.train.service.Impl;

import com.train.exception.BaseException;
import com.train.mapper.CertificateMapper;
import com.train.service.CertificateService;
import com.train.vo.CertificateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;

    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    @Override
    public CertificateVO getByNumber(String number) {
        CertificateVO certificateVO = certificateMapper.getByNumber(number);
        if (certificateVO == null){
            throw new BaseException("未查到此证书");
        }

        return certificateVO;
    }
}
