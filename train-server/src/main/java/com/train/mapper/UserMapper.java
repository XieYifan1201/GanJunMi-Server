package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.UserAddDTO;
import com.train.dto.UserDTO;
import com.train.entity.User;
import com.train.vo.UserVO;
import com.train.vo.UserVO1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 用户Mapper接口
 * 处理用户相关数据库操作
 */
@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     * @param openid 微信openid
     * @return 用户信息
     */
    @Select("select * from users where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 新增用户
     * @param user 用户信息
     */
    void save(User user);

    /**
     * 修改用户信息
     * @param user 用户信息
     */
    void update(User user);

    /**
     * 根据ID获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    @Select("select * from users where id = #{id}")
    User getById(Long id);

    /**
     * 分页查询用户列表
     * @param name 用户名（模糊查询）
     * @return 分页结果
     */
    Page<UserVO1> pageQuery(String name);

    /**
     * 根据用户名和密码查询用户
     * @param user 用户名
     * @param password 密码（MD5加密后）
     * @return 用户信息
     */
    @Select("select * from users where openid = #{user} and password = #{password}")
    User getByPwd(String user, String password);

    /**
     * 添加管理员用户
     * @param userAddDTO 管理员信息
     */
    void add(UserAddDTO userAddDTO);

    /**
     * 修改用户密码
     * @param id 用户ID
     * @param password 新密码（MD5加密后）
     */
    @Update("update users set password = #{password} where id = #{id}")
    void editPwd(Long id, String password);

    /**
     * 重置用户密码为默认密码
     * @param id 用户ID
     */
    @Update("update users set password = 'trains@123456' where id = #{id}")
    void resetPwd(int id);

    /**
     * 删除用户
     * @param id 用户ID
     */
    @Delete("delete from users where id = #{id}")
    void delete(Long id);

    /**
     * 更新用户证件照
     * @param path 证件照路径
     * @param id 用户ID
     */
    @Update("update users set image = #{path} where id = #{id}")
    void addImage(String path,Long id);

    /**
     * 根据openid获取用户信息
     * @param openid 微信openid
     * @return 用户信息
     */
    @Select("select * from users where openid = #{openid}")
    User getOpenId(String openid);
}
