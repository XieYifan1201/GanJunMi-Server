package com.train.service;

import com.train.dto.UserAuthorizeDTO;
import com.train.dto.UserDTO;
import com.train.dto.UserLoginDTO;
import com.train.dto.UserPageQueryDTO;
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

}
