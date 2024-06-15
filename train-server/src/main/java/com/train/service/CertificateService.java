package com.train.service;

import com.train.vo.CertificateVO;

public interface CertificateService {
    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    CertificateVO getByNumber(String number);
}
