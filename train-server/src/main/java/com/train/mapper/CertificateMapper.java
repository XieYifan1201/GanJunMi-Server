package com.train.mapper;

import com.train.entity.Certificate;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 根据id删除数据
     * @param certificateId
     */
    @Delete("delete from certificate where id = #{certificateId}")
    void delete(Long certificateId);
}
