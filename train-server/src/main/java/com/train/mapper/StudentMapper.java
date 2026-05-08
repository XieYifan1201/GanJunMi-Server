package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.PayState;
import com.train.dto.StudentPageQueryDTO;
import com.train.entity.Student;
import com.train.vo.StudentC;
import com.train.vo.StudentInfoVo;
import org.apache.ibatis.annotations.*;

/**
 * 学员Mapper接口
 * 处理学员信息相关数据库操作
 */
@Mapper
public interface StudentMapper {

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
    @Select("select * from studentinfo where id = #{id}")
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
    @Delete("delete from studentinfo where id = #{id}")
    void delete(Long id);

    /**
     * 分页查询学员信息
     * @param pageQueryDTO 查询参数
     * @return 分页结果
     */
    Page<Student> getByBatch(StudentPageQueryDTO pageQueryDTO);

    /**
     * 分页查询学员信息（包含发票信息）
     * @param name 学员姓名
     * @param state 查询状态
     * @param reverse 是否倒序
     * @param payState 缴费状态
     * @return 分页结果
     */
    Page<StudentInfoVo> getByBatch1(String name,int state,boolean reverse,int payState);

    /**
     * 根据身份证号获取学员信息
     * @param idCard 身份证号
     * @return 学员信息
     */
    @Select("select * from studentinfo where idCard = #{idCard}")
    Student getByIdCard(String idCard);

    /**
     * 更新学员开票信息ID
     * @param id 学员ID
     * @param invoiceId 开票信息ID
     */
    @Update("update studentinfo set invoiceId = #{invoiceId} where id = #{id}")
    void updateInvoiceId(Long id,int invoiceId);

    /**
     * 更新学员缴费状态
     * @param state 缴费状态参数
     */
    void updatePayStatus(PayState state);

    /**
     * 分页查询学员信息（包含班次信息）
     * @param pageQueryDTO 查询参数
     * @return 分页结果
     */
    Page<StudentC> getByBatch2(StudentPageQueryDTO pageQueryDTO);
}
