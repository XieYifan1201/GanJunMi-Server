package com.train.mapper;

import com.train.dto.CertificateDTO;
import com.train.entity.Certificate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CertificateMapper {

    /**
     * 添加证书信息
     * @param certificateDTO
     */
    void save(CertificateDTO certificateDTO);

    /**
     * 修改数据
     * @param certificateDTO
     */
    void update(CertificateDTO certificateDTO);

    /**
     * 根据id删除数据
     * @param certificateId
     */
    @Delete("delete from certificate where id = #{certificateId}")
    void delete(Long certificateId);

    /**
     * 根据培训期数id查询证书信息
     * @param trainsInfoId
     * @return
     */
    @Select("select * from certificate where trainsInfoId = #{trainsInfoId}")
    Certificate getCertificate(int trainsInfoId);

    /**
     * 根据id查询证书信息
     * @param id
     * @return
     */
    @Select("select * from certificate where id = #{id}")
    Certificate getById(int id);

    /**
     * 根据培训期数id删除证书信息
     * @param id
     */
    @Delete("delete from certificate where trainsInfoId = #{id}")
    void deleteByTrainsInfoId(int id);
}
