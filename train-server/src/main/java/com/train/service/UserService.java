package com.train.service;

import com.train.dto.*;
import com.train.entity.User;
import com.train.result.PageResult;
import com.train.vo.UserVO;

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
    UserVO getById();

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @return
     */
    PageResult page(UserPageQueryDTO userPageQueryDTO);

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
     * 管理员密码重置
     * @param id
     */
    void resetPwd(Long id);

    /**
     * 修改密码
     * @param currentId
     * @param password
     */
    void editPwd(Long currentId, String password);

    /**
     * 删除管理员
     * @param id
     */
    void delete(Long id);

    /**
     * 用户证件照上传
     * @param path
     */
    void addImage(String path);
}
