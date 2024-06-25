package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.entity.Certificate;
import com.train.entity.UsersCertificate;
import com.train.vo.CertificateVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserCertificateMapper {

    /**
     * 通过id获取证书信息（不包含别的表）
     * @param id
     * @return
     */
    @Select("select * from userscertificate where id = #{id}")
    UsersCertificate getById(Long id);

    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    CertificateVO getByNumber(String number);

    /**
     * 添加证书信息
     * @param usersCertificate
     */
    void save(UsersCertificate usersCertificate);

    /**
     * 分页查询
     * @param name
     * @return
     */
    Page<CertificateVO> pageQuery(String name);

    /**
     * 修改数据
     * @param usersCertificate
     */
    void update(UsersCertificate usersCertificate);

    /**
     * 根据id删除数据
     * @param id
     */
    @Delete("delete from userscertificate where id = #{id}")
    void delete(Long id);
}
