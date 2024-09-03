package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.TrainsClassDTO;
import com.train.dto.TrainsClassDTO1;
import com.train.entity.TrainsClass;
import com.train.vo.ClassesVO;
import com.train.vo.TrainsClassVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TrainsClassMapper {


    /**
     * 批量添加班次信息
     * @param classInfo
     */
    void addBatch(List<TrainsClassDTO> classInfo);

    /**
     * 根据期数id删除所有相应的班次信息
     * @param id
     */
    @Delete("delete from trainsclass where trainsInfoId = #{id}")
    void delete(int id);



    /**
     * 根据期次id获取班次信息
     * @param id
     * @return
     */
    List<TrainsClassVO> getByTrainsId(int id);

    /**
     * 根据id获取同期班次的id集合
     * @param id
     */
    List<Integer> getIds(int id);


    /**
     * 修改count字段
     * @param trainsClassId
     * @param count
     */
    @Update("update trainsclass set count = #{count} where trainsClassId = #{trainsClassId}")
    void setCount(int trainsClassId, int count);

    /**
     * 通过班次id获取班次信息
     * @param trainClassId
     */
    @Select("select * from trainsclass where trainsClassId = #{trainClassId}")
    TrainsClass getById(Integer trainClassId);

    /**
     * 添加班次信息
     * @param trainsClassDTO
     */
    void add(TrainsClassDTO trainsClassDTO);

    /**
     * 根据id删除班次信息
     * @param id
     */
    @Delete("delete from trainsclass where trainsClassId = #{id}")
    void deleteById(int id);

    /**
     * 根据班次id获取期数id
     * @param id
     * @return
     */
    @Select("select trainsInfoId from trainsclass where trainsClassId = #{id}")
    int getTrainsId(int id);

    /**
     * 修改班次信息
     * @param trainsClass
     */
    void update(TrainsClassDTO1 trainsClass);

    /**
     * 根据期数id获取相关的班次id
     * @param trainsId
     * @return
     */
    @Select("select trainsClassId from trainsclass where trainsInfoId = #{trainsId}")
    List<Integer> getIdByTrainsId(int trainsId);

    /**
     * 分页获取班次信息
     * @param name
     * @return
     */
    Page<ClassesVO> getClassInfo(String name);

    /**
     * 根据班次id获取最多报名人数
     * @param trainClassId
     * @return
     */
    @Select("select amount from trainsclass where trainsClassId = #{trainClassId}")
    Integer getAmount(Integer trainClassId);
}
