package com.train.service;

import com.train.entity.InvoiceInfo;
import com.train.vo.CompanyInfo;

public interface InvoiceService {

    /**
     * 保存开票信息
     * @param invoiceInfo
     */
    Integer saveInvoice(InvoiceInfo invoiceInfo);

    /**
     * 删除开票信息
     * @param id
     */
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
    InvoiceInfo getInvoiceById(int id);

    /**
     * 根据学生id获取开票信息
     * @param studentId
     * @return
     */
    InvoiceInfo getInvoiceByStudentId(Long studentId);

    /**
     * 添加或修改开票信息
     * @param invoiceInfo
     * @param idCard
     */
    void addOrUpdateInvoice(InvoiceInfo invoiceInfo, String idCard);

    /**
     * 根据身份证获取开票信息
     * @param idCard
     * @return
     */
    InvoiceInfo getInvoiceByIdCard(String idCard);

    /**
     * 根据发票抬头查询数据库中已有的公司发票信息
     * @param invoiceHead
     * @return
     */
    CompanyInfo getCompanyInfo(String invoiceHead);
}
