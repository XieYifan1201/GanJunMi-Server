package com.train.mapper;

import com.train.entity.InvoiceInfo;
import com.train.vo.CompanyInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InvoiceMapper {

    /**
     * 保存开票信息
     * @param invoiceInfo
     */
    void saveInvoice(InvoiceInfo invoiceInfo);

    /**
     * 删除开票信息
     * @param id
     */
    @Delete("delete from invoiceinfo where id = #{id}")
    void deleteInvoice(int id);

    /**
     * 更新开票信息
     * @param invoiceInfo
     */
    void updateInvoice(InvoiceInfo invoiceInfo);

    /**
     * 根据id获取开票信息
     * @param id
     * @return
     */
    @Select("select * from invoiceinfo where id = #{id}")
    InvoiceInfo getInvoiceById(int id);

    /**
     * 根据学员id获取开票信息
     * @param studentId
     * @return
     */
    InvoiceInfo getInvoiceByStudentId(Long studentId);

    /**
     * 根据发票抬头获取公司信息
     * @param invoiceHead
     * @return
     */
    @Select("select * from invoiceinfo where invoiceHead = ${invoiceHead} order by id desc limit 1")
    CompanyInfo getCompanyInfo(String invoiceHead);
}
