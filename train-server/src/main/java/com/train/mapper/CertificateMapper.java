package com.train.mapper;

import com.train.entity.Certificate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateMapper {

    /**
     * 添加证书信息
     * @param certificate
     */
    void save(Certificate certificate);

    /**
     * 修改数据
     * @param certificate
     */
    void update(Certificate certificate);
}
