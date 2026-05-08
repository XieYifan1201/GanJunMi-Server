package com.train.mapper;

import com.train.entity.InvoiceInfo;
import com.train.vo.CompanyInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 发票信息Mapper接口
 * 处理学员开票信息相关数据库操作
 */
@Mapper
public interface InvoiceMapper {

    /**
     * 保存开票信息
     * @param invoiceInfo 开票信息
     */
    void saveInvoice(InvoiceInfo invoiceInfo);

    /**
     * 删除开票信息
     * @param id 开票信息ID
     */
    @Delete("delete from invoiceinfo where id = #{id}")
    void deleteInvoice(int id);

    /**
     * 更新开票信息
     * @param invoiceInfo 开票信息
     */
    void updateInvoice(InvoiceInfo invoiceInfo);

    /**
     * 根据ID获取开票信息
     * @param id 开票信息ID
     * @return 开票信息
     */
    @Select("select * from invoiceinfo where id = #{id}")
    InvoiceInfo getInvoiceById(int id);

    /**
     * 根据学员ID获取开票信息
     * @param studentId 学员ID
     * @return 开票信息
     */
    InvoiceInfo getInvoiceByStudentId(Long studentId);

    /**
     * 根据发票抬头获取公司信息
     * @param invoiceHead 发票抬头
     * @return 公司信息
     */
    @Select("select * from invoiceinfo where invoiceHead = ${invoiceHead} order by id desc limit 1")
    CompanyInfo getCompanyInfo(String invoiceHead);
}
