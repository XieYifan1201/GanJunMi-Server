package com.train.service;

import com.train.dto.*;
import com.train.entity.User;
import com.train.result.PageResult;
import com.train.vo.UserVO;

/**
 * 用户服务接口
 * 处理用户登录、信息管理、权限管理等业务
 */
public interface UserService {
    /**
     * 微信一键登录
     * @param userLoginDTO 登录参数
     * @return 用户信息
     */
    User wxLogin(UserLoginDTO userLoginDTO);

    /**
     * 修改用户信息
     * @param userDTO 用户信息
     */
    void update(UserDTO userDTO);

    /**
     * 获取当前用户信息
     * @return 用户信息
     */
    UserVO getById();

    /**
     * 分页查询用户列表
     * @param userPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult page(UserPageQueryDTO userPageQueryDTO);

    /**
     * 系统管理员修改用户权限
     * @param userAuthorizeDTO 权限修改参数
     */
    void editAuthority(UserAuthorizeDTO userAuthorizeDTO);

    /**
     * 新增管理员账号
     * @param userAddDTO 管理员信息
     */
    void addAdmin(UserAddDTO userAddDTO);

    /**
     * 系统管理员重置管理员密码
     * @param id 管理员ID
     */
    void resetPwd(Long id);

    /**
     * 管理员修改自己的密码
     * @param currentId 当前用户ID
     * @param password 新密码
     */
    void editPwd(Long currentId, String password);

    /**
     * 删除管理员账号
     * @param id 管理员ID
     */
    void delete(Long id);

    /**
     * 用户证件照上传
     * @param path 证件照路径
     */
    void addImage(String path);
}
