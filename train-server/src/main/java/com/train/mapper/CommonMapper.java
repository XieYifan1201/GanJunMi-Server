package com.train.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommonMapper {


    /**
     * 更新文件路径
     * @param p
     */
    @Insert("update emptyform set path = #{p}")
    void save(String p);

    /**
     * 获取文件路径
     * @return
     */
    @Select("select path from emptyform")
    String get();
}
