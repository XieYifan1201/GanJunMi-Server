package com.train.service.Impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.train.constant.MessageConstant;
import com.train.context.BaseContext;
import com.train.dto.UserAuthorizeDTO;
import com.train.dto.UserDTO;
import com.train.dto.UserLoginDTO;
import com.train.dto.UserPageQueryDTO;
import com.train.entity.User;
import com.train.exception.BaseException;
import com.train.mapper.UserMapper;
import com.train.properties.WeChatProperties;
import com.train.result.PageResult;
import com.train.service.UserService;
import com.train.utils.HttpClientUtil;
import com.train.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    /**
     * 微信用户一键登录
     * @param userLoginDTO
     * @return
     */
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

    /**
     * 修改用户信息
     * @param userDTO
     */
    @Override
    public void update(UserDTO userDTO) {
        //手机号合法性判断
        if (userDTO.getPhone() != null && !isNumber(userDTO.getPhone(),"^1[3-9]\\d{9}$")){
            throw new BaseException("输入数据格式不正确");
        }
        //身份证号合法性
        if (userDTO.getIdCard() != null && !isNumber(userDTO.getIdCard(),"^(\\d{17})([0-9]|X|x)$")){
            throw new BaseException("输入数据格式不正确");
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setId(BaseContext.getCurrentId());
        userMapper.update(user);
    }

    /**
     * 获取用户信息
     * @param
     * @return
     */
    @Override
    public UserDTO getById() {
        User user = userMapper.getById(BaseContext.getCurrentId());
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        //身份证信息加密
        String idCard = userDTO.getIdCard();
        if (idCard.length() == 18){
            String newId = idCard.substring(0, 14) + "****";
            userDTO.setIdCard(newId);
        }
        return userDTO;
    }

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @param role  类型
     */
    @Override
    public PageResult page(UserPageQueryDTO userPageQueryDTO, Integer role) {
        User user = userMapper.getById(BaseContext.getCurrentId());
        if (user.getRoleId() != 3){     //非管理员不能查询用户信息
            PageHelper.startPage(userPageQueryDTO.getPage(), userPageQueryDTO.getPageSize());
            Page<UserVO> p = userMapper.pageQuery(userPageQueryDTO.getName(),role);
            for (UserVO userVO : p) {
                String idCard = userVO.getIdCard();
                if (idCard != null && idCard.length() == 18){
                    userVO.setIdCard((idCard.substring(0,14) + "****"));
                }
            }
            return new PageResult(p.getTotal(),p.getResult());
        }else {
            throw new BaseException("权限不足");
        }
    }

    /**
     * 系统管理员修改权限
     */
    @Override
    public void editAuthority(UserAuthorizeDTO userAuthorizeDTO) {
        int roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId == 1){
            //系统管理员才能修改用户权限
            User user = User.builder().id(userAuthorizeDTO.getId()).roleId(userAuthorizeDTO.getRoleId()).build();
            userMapper.update(user);
        }else {
            throw new BaseException("权限不足");
        }
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

    //判断字符串合法性判断
    public static boolean isNumber(String number,String regex) {
        if (number == null) {
            return false;
        }
        return number.matches(regex);
    }


}
