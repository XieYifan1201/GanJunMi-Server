package com.train.service;

import com.train.dto.*;
import com.train.entity.Student;
import com.train.result.PageResult;
import com.train.vo.ApplyInfo;
import com.train.vo.CertificateVO;
import com.train.vo.SignVO;

import java.util.List;

/**
 * 学员服务接口
 * 处理学员报名、信息管理、证书颁发等业务
 */
public interface StudentService {
    /**
     * 学员报名
     * @param signDTO 报名信息
     */
    void sign(SignDTO signDTO);

    /**
     * 添加学员信息
     * @param student 学员信息
     */
    void add(Student student);

    /**
     * 根据ID获取学员信息
     * @param id 学员ID
     * @return 学员信息
     */
    Student getById(Long id);

    /**
     * 修改学员信息
     * @param student 学员信息
     */
    void update(Student student);

    /**
     * 删除学员信息
     * @param id 学员ID
     */
    void delete(Long id);

    /**
     * 分页查询学员信息
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult getByBatch(StudentPageQueryDTO pageQueryDTO);

    /**
     * 获取学员证书信息
     * @param studentIdsDTO 学员ID列表
     * @return 证书信息列表
     */
    List<CertificateVO> getCertificate(StudentIdsDTO studentIdsDTO);

    /**
     * 学员获取自己的报名信息
     * @return 报名信息
     */
    SignVO signInfo();

    /**
     * 分页查询学员信息（包含发票信息）
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult getByBatch1(StudentInvoicePageQueryDTO pageQueryDTO);

    /**
     * 给学员颁发证书
     * @param studentIdsDTO1 学员ID列表
     * @param imgPath 二维码图片路径
     */
    void issueCertificate(StudentIdsDTO1 studentIdsDTO1,String imgPath);

    /**
     * 撤销报名
     * @param id 报名记录ID
     */
    void cancelSign(int id);

    /**
     * 获取学员证书数量
     * @param id 学员ID
     * @return 证书数量
     */
    Integer getCount(Long id);

    /**
     * 修改学员缴费状态
     * @param state 缴费状态参数
     */
    void updatePayStatus(PayState state);

    /**
     * 分页查询学员信息（包含班次信息）
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult getByBatch2(StudentPageQueryDTO pageQueryDTO);

    /**
     * 管理员添加/修改学员报名信息
     * @param signDTO1 报名信息
     */
    void SAUpdateSign(SignDTO1 signDTO1);

    /**
     * 给学员添加/修改特殊证书内容
     * @param certificate 特殊证书信息
     */
    void addCertificateContent(SpecialCertificate certificate);

    /**
     * 获取当前账号的所有报名信息
     * @return 报名信息列表
     */
    List<ApplyInfo> getAllApplyInfo();

}
