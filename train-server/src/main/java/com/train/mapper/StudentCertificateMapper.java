package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.SpecialCertificate;
import com.train.entity.Student;
import com.train.entity.StudentCertificate;
import com.train.vo.ApplyInfo;
import com.train.vo.StudentC;
import com.train.vo.StudentInfoVo;
import com.train.vo.StudentVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 学员报名Mapper接口
 * 处理学员报名记录、证书颁发等数据库操作
 */
@Mapper
public interface StudentCertificateMapper {

    /**
     * 添加报名记录
     * @param sCertificate 报名信息
     */
    void save(StudentCertificate sCertificate);

    /**
     * 根据学员ID查询所有报名记录
     * @param id 学员ID
     * @return 报名记录列表
     */
    List<StudentCertificate> getByStudentId(Long id);

    /**
     * 根据班次ID查询所有报名学员
     * @param trainsClassId 班次ID
     * @param name 学员姓名
     * @param state 查询状态
     * @return 分页结果
     */
    Page<StudentVO> getByTrainsClassId(int trainsClassId, String name,int state);

    /**
     * 批量更新学员证书颁发状态
     * @param ids 报名记录ID列表
     */
    void updateCertificate(List<Integer> ids);

    /**
     * 根据ID列表查询报名记录
     * @param ids 报名记录ID列表
     * @return 报名记录列表
     */
    List<StudentCertificate> getByIds(List<Integer> ids);

    /**
     * 根据证书编号查询证书信息
     * @param number 证书编号
     * @return 报名记录信息
     */
    @Select("select * from studentcertificate where CertificateNo = #{number}")
    StudentCertificate getByCertificateNo(String number);

    /**
     * 获取期数下报名的所有学员信息
     * @param classIds 班次ID集合
     * @param name 学员姓名
     * @param sex 性别
     * @param workUnit 工作单位
     * @param idCard 身份证号
     * @param reverse 是否倒序
     * @param city 城市
     * @return 分页结果
     */
    Page<Student> getStudentBatch(List<Integer> classIds, String name, String sex, String workUnit, String idCard,boolean reverse,String city);

    /**
     * 获取班次信息及学员信息（包含班次信息）
     * @param classIds 班次ID集合
     * @param name 学员姓名
     * @param sex 性别
     * @param workUnit 工作单位
     * @param idCard 身份证号
     * @param reverse 是否倒序
     * @param city 城市
     * @return 分页结果
     */
    Page<StudentC> getStudentBatch2(List<Integer> classIds, String name, String sex, String workUnit, String idCard, boolean reverse, String city);

    /**
     * 获取报名班次的学员总数
     * @param trainsClassId 班次ID
     * @return 学员总数
     */
    @Select("select count(*) from studentcertificate where trainsClassId = #{trainsClassId}")
    Integer getClassCount(int trainsClassId);

    /**
     * 删除指定学员的所有报名记录
     * @param id 学员ID
     */
    @Delete("delete from studentcertificate where studentId = #{id}")
    void deleteByStudentId(Long id);

    /**
     * 删除指定报名记录
     * @param studentCertificateId 报名记录ID
     */
    @Delete("delete from studentcertificate where id = #{studentCertificateId}")
    void deleteById(int studentCertificateId);

    /**
     * 查询该学员的证书数量
     * @param id 学员ID
     * @param flag 查询标志
     * @return 证书数量
     */
    int getCertificateCount(Long id,boolean flag);

    /**
     * 获取报名班次的学员信息和发票信息
     * @param classIds 班次ID集合
     * @param name 学员姓名
     * @param state 查询状态
     * @param reverse 是否倒序
     * @param payState 缴费状态
     * @return 分页结果
     */
    Page<StudentInfoVo> getStudentBatch1(List<Integer> classIds, String name, int state,boolean reverse,int payState);

    /**
     * 更新报名记录
     * @param studentCertificate 报名信息
     */
    void update(StudentCertificate studentCertificate);

    /**
     * 批量更新报名记录
     * @param list 报名信息列表
     */
    void updateBatch(List<StudentCertificate> list);

    /**
     * 根据ID查询报名记录
     * @param id 报名记录ID
     * @return 报名信息
     */
    @Select("select * from studentcertificate where id = #{id}")
    StudentCertificate getById(int id);

    /**
     * 更新学员特殊证书信息
     * @param certificate 特殊证书信息
     */
    @Update("update studentcertificate set special_content = #{content} where id = #{id}")
    void addSpecial(SpecialCertificate certificate);

    /**
     * 获取该账号所有报名信息
     * @param currentId 当前用户ID
     * @return 报名信息列表
     */
    List<ApplyInfo> getAllApplyInfo(Long currentId);

}
