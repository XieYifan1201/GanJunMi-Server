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

@Mapper
public interface StudentCertificateMapper {


    /**
     * 添加报名信息
     * @param sCertificate
     */
    void save(StudentCertificate sCertificate);

    /**
     * 通过学员id查询所有报名信息
     * @param id
     */
    List<StudentCertificate> getByStudentId(Long id);

    /**
     * 通过班次id查询所有报名信息
     * @param trainsClassId
     */
    Page<StudentVO> getByTrainsClassId(int trainsClassId, String name);

    /**
     * 更改学员的颁发证书状态
     * @param ids
     */
    void updateCertificate(List<Integer> ids);


    /**
     * 通过id查询证书信息
     * @param ids
     * @return
     */
    List<StudentCertificate> getByIds(List<Integer> ids);

    /**
     * 证书编号获取证书信息
     * @param number
     * @return
     */
    @Select("select * from studentcertificate where CertificateNo = #{number}")
    StudentCertificate getByCertificateNo(String number);

    /**
     * 获取期数下报名的所有学员信息
     * @param classIds 班次id集合
     * @param name
     * @param sex
     * @param workUnit
     * @param idCard
     * @return
     */
    Page<Student> getStudentBatch(List<Integer> classIds, String name, String sex, String workUnit, String idCard,boolean reverse,String city);


    /**
     * 获取班次信息及学员信息
     * @param classIds
     * @param name
     * @param sex
     * @param workUnit
     * @param idCard
     * @param reverse
     * @param city
     * @return
     */
    Page<StudentC> getStudentBatch2(List<Integer> classIds, String name, String sex, String workUnit, String idCard, boolean reverse, String city);

    /**
     * 获取报名班次的学员总数
     * @param trainsClassId
     * @return
     */
    @Select("select count(*) from studentcertificate where trainsClassId = #{trainsClassId}")
    Integer getClassCount(int trainsClassId);

    /**
     *
     * 删除指定学员的所有信息
     * @param id
     */
    @Delete("delete from studentcertificate where studentId = #{id}")
    void deleteByStudentId(Long id);

    /**
     * 删除指定报名信息
     * @param studentCertificateId
     */
    @Delete("delete from studentcertificate where id = #{studentCertificateId}")
    void deleteById(int studentCertificateId);

    /**
     * 查询该学员证书的数量
     * @param id 学员id
     * @return
     */
    int getCertificateCount(Long id,boolean flag);

    /**
     * 获取报名班次的学员信息和发票信息
     * @param classIds
     * @param name
     * @param state
     * @return
     */
    Page<StudentInfoVo> getStudentBatch1(List<Integer> classIds, String name, int state,boolean reverse,int payState);

    /**
     * 更新报名信息
     * @param studentCertificate
     */
    void update(StudentCertificate studentCertificate);


    /**
     * 批量更新报名信息(特殊)
     * @param list
     */
    void updateBatch(List<StudentCertificate> list);

    @Select("select * from studentcertificate where id = #{id}")
    StudentCertificate getById(int id);

    /**
     * 学员添加/修改特殊证书信息
     * @param certificate
     */
    @Update("update studentcertificate set special_content = #{content} where id = #{id}")
    void addSpecial(SpecialCertificate certificate);

    /**
     * 获取该账号所有报名信息
     * @param currentId
     * @return
     */
    List<ApplyInfo> getAllApplyInfo(Long currentId);

}
