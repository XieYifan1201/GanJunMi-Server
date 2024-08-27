package com.train.service.Impl;

import com.train.entity.InvoiceInfo;
import com.train.entity.Student;
import com.train.exception.BaseException;
import com.train.mapper.InvoiceMapper;
import com.train.mapper.StudentMapper;
import com.train.service.InvoiceService;
import com.train.vo.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 保存开票信息
     * @param invoiceInfo
     */
    @Override
    public Integer saveInvoice(InvoiceInfo invoiceInfo) {
        invoiceMapper.saveInvoice(invoiceInfo);
        return invoiceInfo.getId();
    }

    /**
     * 删除开票信息
     * @param id
     */
    @Override
    public void deleteInvoice(int id) {
        invoiceMapper.deleteInvoice(id);
    }

    /**
     * 修改开票信息
     * @param invoiceInfo
     */
    @Override
    public void updateInvoice(InvoiceInfo invoiceInfo) {
        invoiceMapper.updateInvoice(invoiceInfo);
    }

    /**
     * 根据id获取开票信息
     * @param id
     * @return
     */
    @Override
    public InvoiceInfo getInvoiceById(int id) {
        return invoiceMapper.getInvoiceById(id);
    }

    /**
     * 根据学生id获取开票信息
     * @param studentId
     * @return
     */
    @Override
    public InvoiceInfo getInvoiceByStudentId(Long studentId) {
        return invoiceMapper.getInvoiceByStudentId(studentId);
    }

    /**
     * 添加或修改开票信息
     * @param invoiceInfo
     * @param idCard
     */
    @Override
    public void addOrUpdateInvoice(InvoiceInfo invoiceInfo, String idCard) {
        Student student = studentMapper.getByIdCard(idCard);
        if (student == null){
            throw new BaseException("当前还未报名，不能添加发票信息");
        }
        Integer invoiceId = student.getInvoiceId();
        if (invoiceId == null ){
            //不存在，添加
            invoiceMapper.saveInvoice(invoiceInfo);
            studentMapper.updateInvoiceId(student.getId(),invoiceInfo.getId());
        }else {
            //存在，修改
            invoiceInfo.setId(invoiceId);
            invoiceMapper.updateInvoice(invoiceInfo);
        }
    }

    @Override
    public InvoiceInfo getInvoiceByIdCard(String idCard) {
        Student student = studentMapper.getByIdCard(idCard);
        if (student != null){
            if (student.getInvoiceId() == null){
                throw new BaseException("当前学员未添加发票信息");
            }
            return invoiceMapper.getInvoiceById(student.getInvoiceId());
        }else{
            throw new BaseException("当前学员未报名");
        }
    }

    /**
     * 根据发票抬头查询数据库中已有的公司发票信息
     * @param invoiceHead
     * @return
     */
    @Override
    public CompanyInfo getCompanyInfo(String invoiceHead) {
        if (invoiceHead != null){
            return invoiceMapper.getCompanyInfo(invoiceHead);
        }
        return null;
    }
}
