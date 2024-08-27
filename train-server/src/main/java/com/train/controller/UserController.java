package com.train.controller;

import com.train.constant.JwtConstant;
import com.train.context.BaseContext;
import com.train.dto.*;
import com.train.entity.User;
import com.train.properties.JwtProperties;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.UserService;
import com.train.utils.JwtUtil;
import com.train.vo.UserLoginVO;
import com.train.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户相关接口")
@Slf4j
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("微信登录：{}",userLoginDTO);
        //用户信息
        User user = userService.wxLogin(userLoginDTO);
        //生成jwt令牌
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtConstant.USER_ID,user.getId());
        claims.put("openid",user.getOpenid());
        String token = JwtUtil.createJWT(jwtProperties.getSecretKey(), jwtProperties.getTtl(), claims);

        return Result.success(UserLoginVO.builder().
                token(token).roleId(user.getRoleId()).name(user.getName())
                        .sex(user.getSex()).image(user.getImage()).id(user.getId())
                        .idCard(user.getIdCard()).phone(user.getPhone()).build());
    }

    @ApiOperation("用户证件照上传")
    @GetMapping("/addImage")
    public Result addImage(String path){
        log.info("用户证件照上传:{}",path);
        userService.addImage(path);
        return Result.success();
    }

    @ApiOperation("新增管理员")
    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody UserAddDTO userAddDTO){
        log.info("新增管理员:{}",userAddDTO);
        userService.addAdmin(userAddDTO);
        return Result.success();
    }

    @ApiOperation("重置管理员密码")
    @GetMapping("/resetPwd")
    public Result resetPwd(Long id){
        log.info("重置管理员密码:{}",id);
        userService.resetPwd(id);
        return Result.success();
    }

    @ApiOperation("修改自己密码（管理员）")
    @GetMapping("/editPwd")
    public Result editPwd(String password){
        log.info("修改密码:{}",password);
        userService.editPwd(BaseContext.getCurrentId(),password);
        return Result.success();
    }

    @ApiOperation("删除管理员")
    @GetMapping("/delete")
    public Result delete(Long id){
        log.info("删除管理员:{}",id);
        userService.delete(id);
        return Result.success();
    }



    @PutMapping("/update")
    @ApiOperation("修改用户信息")
    public Result update(@RequestBody UserDTO userDTO){
        log.info("修改用户信息:{}",userDTO);
        userService.update(userDTO);
        return Result.success();
    }

    @GetMapping("/getById")
    @ApiOperation("获取用户信息")
    public Result<UserVO> getById(){
        log.info("获取用户信息");
        UserVO userDTO = userService.getById();
        return Result.success(userDTO);
    }

    /*
    @GetMapping("/page2")
    @ApiOperation("学员分页查询")
    public Result<PageResult> page2(UserPageQueryDTO userPageQueryDTO){
        log.info("学员分页查询:{}",userPageQueryDTO);
        PageResult pageResult = userService.page(userPageQueryDTO, 3);
        return Result.success(pageResult);
    }

     */

    @GetMapping("/page1")
    @ApiOperation("管理员分页查询")
    public Result<PageResult> page1(UserPageQueryDTO userPageQueryDTO){
        log.info("管理员分页查询:{},{}",userPageQueryDTO);
        PageResult pageResult = userService.page(userPageQueryDTO);
        return Result.success(pageResult);
    }

    @ApiOperation("系统管理员修改权限")
    @PutMapping("/editAuthority")
    public Result editAuthority(@RequestBody UserAuthorizeDTO userAuthorizeDTO){
        log.info("系统管理员修改权限:{}",userAuthorizeDTO);
        userService.editAuthority(userAuthorizeDTO);
        return Result.success();
    }

}
