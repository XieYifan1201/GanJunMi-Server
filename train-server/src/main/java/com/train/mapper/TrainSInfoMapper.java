package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.entity.TrainsInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 培训期次Mapper接口
 * 处理培训期次信息相关数据库操作
 */
@Mapper
public interface TrainSInfoMapper {

    /**
     * 添加培训期次信息
     * @param trainsInfo 期次信息
     */
    void add(TrainsInfo trainsInfo);

    /**
     * 删除培训期次信息
     * @param id 期次ID
     */
    @Delete("delete from trainsinfo where trainsId = #{id}")
    void delete(int id);

    /**
     * 更新培训期次信息
     * @param trainsInfo 期次信息
     */
    void update(TrainsInfo trainsInfo);

    /**
     * 分页查询期次信息
     * @param name 期次名称
     * @param state 查询状态
     * @return 分页结果
     */
    Page<TrainsInfo> pageQuery(String name,int state);

    /**
     * 设置是否允许报名
     * @param id 期次ID
     * @param isStart 是否允许报名
     */
    @Update("update trainsinfo set isStart = #{isStart} where trainsId = #{id}")
    void setStart(int id, boolean isStart);

    /**
     * 根据ID获取期次信息
     * @param trainsId 期次ID
     * @return 期次信息
     */
    @Select("select * from trainsinfo where trainsId = #{trainsId}")
    TrainsInfo getById(Integer trainsId);

    /**
     * 获取期次班级总数
     * @param id 期次ID
     * @return 班级总数
     */
    @Select("select trainsCount from trainsinfo where trainsId = #{id}")
    int getCount(int id);

    /**
     * 更新期次班级总数
     * @param id 期次ID
     * @param count 班级总数
     */
    @Update("update trainsinfo set trainsCount = #{count} where trainsId = #{id}")
    void updateCount(int id, int count);

    /**
     * 获取最后一期期次信息
     * @return 期次信息
     */
    @Select("select * from trainsinfo order by trainsId desc limit 1")
    TrainsInfo getLast();

}
