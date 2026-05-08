package com.train.mapper;

import com.train.dto.CertificateDTO;
import com.train.entity.Certificate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 证书Mapper接口
 * 处理证书信息相关数据库操作
 */
@Mapper
public interface CertificateMapper {

    /**
     * 添加证书信息
     * @param certificateDTO 证书信息
     */
    void save(CertificateDTO certificateDTO);

    /**
     * 更新证书信息
     * @param certificateDTO 证书信息
     */
    void update(CertificateDTO certificateDTO);

    /**
     * 根据ID删除证书
     * @param certificateId 证书ID
     */
    @Delete("delete from certificate where id = #{certificateId}")
    void delete(Long certificateId);

    /**
     * 根据培训期数ID查询证书信息
     * @param trainsInfoId 期数ID
     * @return 证书信息
     */
    @Select("select * from certificate where trainsInfoId = #{trainsInfoId}")
    Certificate getCertificate(int trainsInfoId);

    /**
     * 根据ID查询证书信息
     * @param id 证书ID
     * @return 证书信息
     */
    @Select("select * from certificate where id = #{id}")
    Certificate getById(int id);

    /**
     * 根据培训期数ID删除证书信息
     * @param id 期数ID
     */
    @Delete("delete from certificate where trainsInfoId = #{id}")
    void deleteByTrainsInfoId(int id);
}
