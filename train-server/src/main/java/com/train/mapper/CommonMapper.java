package com.train.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 通用Mapper接口
 * 处理通用数据操作
 */
@Mapper
public interface CommonMapper {

    /**
     * 更新文件路径
     * @param p 文件路径
     */
    @Insert("update emptyform set path = #{p}")
    void save(String p);

    /**
     * 获取文件路径
     * @return 文件路径
     */
    @Select("select path from emptyform")
    String get();
}
