package com.train.service.Impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.train.constant.MessageConstant;
import com.train.dto.UserLoginDTO;
import com.train.entity.User;
import com.train.exception.BaseException;
import com.train.mapper.UserMapper;
import com.train.properties.WeChatProperties;
import com.train.service.UserService;
import com.train.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    //微信服务接口
    public static final String WX_LOGIN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    @Autowired
    private WeChatProperties weChatProperties;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User wxLogin(UserLoginDTO userLoginDTO) {
        String openid = getOpenid(userLoginDTO.getCode());

        if (openid == null){
            throw new BaseException(MessageConstant.LOGIN_FAILED);
        }

        //当前数据库中是否有该openid ，没有保存
        User user = userMapper.getByOpenid(openid);
        if (user == null){
            user = User.builder().openid(openid).createTime(LocalDateTime.now()).build();
            userMapper.save(user);
        }

        return user;
    }

    //网络请求，向微信服务器获取openId
    private String getOpenid(String code) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("appid",weChatProperties.getAppid());
        paramMap.put("secret",weChatProperties.getSecret());
        paramMap.put("code", code);
        paramMap.put("grant_type","authorization_code");
        String json = HttpClientUtil.doGet(WX_LOGIN, paramMap);  //微信服务器返回的结果
        log.info("微信后台访问结果：{}", json);
        JSONObject jsonObject = JSON.parseObject(json);

        String openid = jsonObject.getString("openid");
        return openid;
    }
}
