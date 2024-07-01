package com.train.service;

import com.train.dto.*;
import com.train.entity.User;
import com.train.result.PageResult;

public interface UserService {
    /**
     * 微信一键登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);

    /**
     * 修改用户信息
     * @param userDTO
     */
    void update(UserDTO userDTO);

    /**
     * 获取用户信息
     * @param
     * @return
     */
    UserDTO getById();

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @param role
     * @return
     */
    PageResult page(UserPageQueryDTO userPageQueryDTO, Integer role);

    /**
     * 系统管理员修改权限
     */
    void editAuthority(UserAuthorizeDTO userAuthorizeDTO);

    /**
     * 新增管理员
     * @param userAddDTO
     */
    void addAdmin(UserAddDTO userAddDTO);

    /**
     * 修改管理员密码
     * @param id
     * @param password
     */
    void editPwd(Long id, String password);
}
