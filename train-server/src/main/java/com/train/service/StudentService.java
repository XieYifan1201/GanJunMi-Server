package com.train.service;

import com.train.dto.*;
import com.train.entity.Student;
import com.train.result.PageResult;
import com.train.vo.CertificateVO;
import com.train.vo.SignVO;

import java.util.List;

public interface StudentService {
    /**
     * 学员报名
     * @param signDTO
     */
    void sign(SignDTO signDTO);

    /**
     * 学员信息添加
     * @param student
     */
    void add(Student student);

    /**
     * 根据id获取学员信息
     * @param id
     * @return
     */
    Student getById(Long id);

    /**
     * 修改学员信息
     * @param student
     */
    void update(Student student);

    /**
     * 删除学员信息
     * @param id
     */
    void delete(Long id);

    /**
     * 分页查询学员信息
     * @param pageQueryDTO
     * @return
     */
    PageResult getByBatch(StudentPageQueryDTO pageQueryDTO);


    /**
     * 颁发证书
     * @param studentIdsDTO
     * @return
     */
    List<CertificateVO> getCertificate(StudentIdsDTO studentIdsDTO);

    /**
     * 学员获得自己报名信息
     */
    SignVO signInfo();

    /**
     * 分页查询学员信息(包含发票信息)
     * @param pageQueryDTO
     * @return
     */
    PageResult getByBatch1(StudentInvoicePageQueryDTO pageQueryDTO);

    /**
     * 颁发证书
     * @param studentIdsDTO1
     */
    void issueCertificate(StudentIdsDTO1 studentIdsDTO1,String imgPath);

    /**
     * 撤销报名
     * @param id
     */
    void cancelSign(int id);

    /**
     * 获取学员证书数量
     * @param id
     * @return
     */
    Integer getCount(Long id);

    /**
     * 修改缴费状态
     */
    void updatePayStatus(PayState state);

    /**
     * 分页查询学员信息(包含班次信息)
     * @param pageQueryDTO
     * @return
     */
    PageResult getByBatch2(StudentPageQueryDTO pageQueryDTO);

    /**
     * 添加/修改学员报名信息
     * @param signDTO1
     */
    void SAUpdateSign(SignDTO1 signDTO1);
}
