package com.train.mapper;

import com.train.vo.CertificateVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateMapper {


    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    CertificateVO getByNumber(String number);
}
