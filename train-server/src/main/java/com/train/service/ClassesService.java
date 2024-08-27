package com.train.service;

import com.train.dto.*;
import com.train.entity.Certificate;
import com.train.entity.TrainsClass;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.vo.TrainsClassVO;

import java.util.List;

public interface ClassesService {
    /**
     * 添加开班信息
     * @param trainsInfoDTO
     */
    void addClasses(TrainsInfoDTO trainsInfoDTO);

    /**
     * 删除开班信息
     * @param id
     */
    void delete(int id);

    /**
     * 修改开班信息
     * @param trainsInfoDTO
     */
    void updateClasses(TrainsInfoDTO trainsInfoDTO);

    /**
     * 分页查询期数信息
     * @param pageQueryDTO
     * @return
     */
    PageResult getByBatch(ClassesPageQueryDTO pageQueryDTO);

    /**
     * 根据期数id获取班次信息
     * @param id
     * @return
     */
    List<TrainsClassVO> getByTrainsId(int id);

    /**
     * 设置是否允许报名
     * @param id
     * @param isStart
     */
    void setStart(int id, boolean isStart);

    /**
     * 给这期培训添加/修改证书信息
     * @param certificateDTO
     */
    void save(CertificateDTO certificateDTO);

    /**
     * 根据期数id获取证书信息
     * @param trainsInfoId
     * @return
     */
    Certificate getCertificate(int trainsInfoId);

    /**
     * 获取报名班次的学员信息
     * @param pageQueryDTO
     */
    PageResult getStudentByTrainsClassId(StudentByClassDTO pageQueryDTO);

    /**
     * 给这期培训添加班次信息
     * @param trainsClassDTO
     */
    void addClass(TrainsClassDTO trainsClassDTO);

    /**
     * 删除班次信息
     * @param id
     */
    void deleteByTrainsClassId(int id);

    /**
     * 修改班次信息
     * @param trainsClass
     */
    void updateClass(TrainsClassDTO1 trainsClass);

    /**
     * 获取报名班级的总人数
     * @return
     */
    Integer getClassCount(int trainsClassId);

    /**
     * 管理员取消学员报名
     * @param studentCertificateId
     */
    void deleteByStudentCertificate(int studentCertificateId);

    /**
     * 分页获取班次信息
     * @param pageQueryDTO
     * @return
     */
    PageResult getClassInfo(PageQueryDTO pageQueryDTO);
}
