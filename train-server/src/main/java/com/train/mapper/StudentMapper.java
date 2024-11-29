package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.PayState;
import com.train.dto.StudentPageQueryDTO;
import com.train.entity.Student;
import com.train.vo.StudentC;
import com.train.vo.StudentInfoVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

    /**
     * 添加学员信息
     * @param student
     */
    void add(Student student);

    /**
     * 根据id获取学员信息
     * @param id
     * @return
     */
    @Select("select * from studentinfo where id = #{id}")
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
    @Delete("delete from studentinfo where id = #{id}")
    void delete(Long id);

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    Page<Student> getByBatch(StudentPageQueryDTO pageQueryDTO);

    /**
     * 分页查询学员信息(包含发票信息)
     * @param name
     * @return
     */
    Page<StudentInfoVo> getByBatch1(String name,int state,boolean reverse,int payState);

    /**
     * 根据身份证号获取学员信息
     * @param idCard
     * @return
     */
    @Select("select * from studentinfo where idCard = #{idCard}")
    Student getByIdCard(String idCard);


    /**
     * 修改学员开票信息id
     * @param id
     */
    @Update("update studentinfo set invoiceId = #{invoiceId} where id = #{id}")
    void updateInvoiceId(Long id,int invoiceId);

    /**
     * 修改学员的缴费状态
     * @param state
     */
    void updatePayStatus(PayState state);

    /**
     * 分页查询学员信息(包含班次信息)
     * @param pageQueryDTO
     * @return
     */
    Page<StudentC> getByBatch2(StudentPageQueryDTO pageQueryDTO);
}
