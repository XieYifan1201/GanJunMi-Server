package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.entity.TrainsInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TrainSInfoMapper {


    /**
     * 添加数据
     * @param trainsInfo
     */
    void add(TrainsInfo trainsInfo);

    /**
     * 删除数据
     * @param id
     */
    @Delete("delete from trainsinfo where trainsId = #{id}")
    void delete(int id);

    /**
     * 修改数据
     * @param trainsInfo
     */
    void update(TrainsInfo trainsInfo);

    /**
     * 分页查询期数信息
     * @param name
     * @return
     */
    Page<TrainsInfo> pageQuery(String name,int state);

    /**
     * 设置是否允许报名
     * @param id
     * @param isStart
     */
    @Update("update trainsinfo set isStart = #{isStart} where trainsId = #{id}")
    void setStart(int id, boolean isStart);

    /**
     * 通过id获取数据
     * @param trainsId
     */
    @Select("select * from trainsinfo where trainsId = #{trainsId}")
    TrainsInfo getById(Integer trainsId);

    /**
     * 获取期数班级总数
     * @return
     */
    @Select("select trainsCount from trainsinfo where trainsId = #{id}")
    int getCount(int id);

    /**
     * 修改班级总数
     * @param id
     * @param count
     */
    @Update("update trainsinfo set trainsCount = #{count} where trainsId = #{id}")
    void updateCount(int id, int count);

}
