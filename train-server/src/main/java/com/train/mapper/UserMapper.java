package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.UserDTO;
import com.train.entity.User;
import com.train.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from users where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 新增用户
     * @param user
     */
    void save(User user);


    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);


    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    User getById(Long id);


    /**
     * 分页查询
     * @param role
     * @return
     */
    Page<UserVO> pageQuery(String name,Integer role);
}
