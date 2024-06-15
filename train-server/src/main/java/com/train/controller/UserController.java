package com.train.controller;

import com.train.constant.JwtConstant;
import com.train.dto.UserLoginDTO;
import com.train.entity.User;
import com.train.properties.JwtProperties;
import com.train.result.Result;
import com.train.service.UserService;
import com.train.utils.JwtUtil;
import com.train.vo.UserLoginVO;
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

        return Result.success(UserLoginVO.builder().token(token).build());
    }

}
