package com.train.mapper;

import com.github.pagehelper.Page;
import com.train.dto.UserAddDTO;
import com.train.dto.UserDTO;
import com.train.entity.User;
import com.train.vo.UserVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
     * @return
     */
    Page<UserVO> pageQuery(String name);

    /**
     * 通过用户名和密码进行查询
     * @param user
     * @param password
     */
    @Select("select * from users where openid = #{user} and password = #{password}")
    User getByPwd(String user, String password);

    /**
     * 添加管理员用户
     * @param userAddDTO
     */
    void add(UserAddDTO userAddDTO);

    /**
     * 修改管理员密码
     * @param id
     * @param password
     */
    @Update("update users set password = #{password} where id = #{id}")
    void editPwd(Long id, String password);

    /**
     * 重置密码
     * @param id
     */
    @Update("update users set password = 'trains@123456' where id = #{id}")
    void resetPwd(int id);

    /**
     * 删除管理员
     * @param id
     */
    @Delete("delete from users where id = #{id}")
    void delete(Long id);

    /**
     * 用户证件照上传
     * @param path
     */
    @Update("update users set image = #{path} where id = #{id}")
    void addImage(String path,Long id);
}
