package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.TrainsClassDTO;
import com.train.dto.TrainsClassDTO1;
import com.train.entity.TrainsClass;
import com.train.vo.ClassesVO;
import com.train.vo.TrainsClassVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 培训班次Mapper接口
 * 处理培训班次相关数据库操作
 */
@Mapper
public interface TrainsClassMapper {

    /**
     * 批量添加班次信息
     * @param classInfo 班次信息列表
     */
    void addBatch(List<TrainsClassDTO> classInfo);

    /**
     * 根据期数ID删除所有相关班次
     * @param id 期数ID
     */
    @Delete("delete from trainsclass where trainsInfoId = #{id}")
    void delete(int id);

    /**
     * 根据期次ID获取班次信息列表
     * @param id 期次ID
     * @return 班次信息列表
     */
    List<TrainsClassVO> getByTrainsId(int id);

    /**
     * 根据期次ID获取同期班次的ID集合
     * @param id 期次ID
     * @return 班次ID列表
     */
    List<Integer> getIds(int id);

    /**
     * 更新班次报名人数
     * @param trainsClassId 班次ID
     * @param count 报名人数
     */
    @Update("update trainsclass set count = #{count} where trainsClassId = #{trainsClassId}")
    void setCount(int trainsClassId, int count);

    /**
     * 根据班次ID获取班次信息
     * @param trainClassId 班次ID
     * @return 班次信息
     */
    @Select("select * from trainsclass where trainsClassId = #{trainClassId}")
    TrainsClass getById(Integer trainClassId);

    /**
     * 添加班次信息
     * @param trainsClassDTO 班次信息
     */
    void add(TrainsClassDTO trainsClassDTO);

    /**
     * 根据班次ID删除班次信息
     * @param id 班次ID
     */
    @Delete("delete from trainsclass where trainsClassId = #{id}")
    void deleteById(int id);

    /**
     * 根据班次ID获取期数ID
     * @param id 班次ID
     * @return 期数ID
     */
    @Select("select trainsInfoId from trainsclass where trainsClassId = #{id}")
    int getTrainsId(int id);

    /**
     * 更新班次信息
     * @param trainsClass 班次信息
     */
    void update(TrainsClassDTO1 trainsClass);

    /**
     * 根据期数ID获取相关班次ID列表
     * @param trainsId 期数ID
     * @return 班次ID列表
     */
    @Select("select trainsClassId from trainsclass where trainsInfoId = #{trainsId}")
    List<Integer> getIdByTrainsId(int trainsId);

    /**
     * 分页获取班次信息
     * @param name 班次名称（模糊查询）
     * @return 分页结果
     */
    Page<ClassesVO> getClassInfo(String name);

    /**
     * 根据班次ID获取最多报名人数
     * @param trainClassId 班次ID
     * @return 最多报名人数
     */
    @Select("select amount from trainsclass where trainsClassId = #{trainClassId}")
    Integer getAmount(Integer trainClassId);
}
