package com.train.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.common.utils.HttpUtil;
import com.train.cache.MyCache;
import com.train.exception.BaseException;
import com.train.properties.WeChatProperties;
import com.train.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务类
 */
@Component
@Slf4j
public class MyTask {

    @Autowired
    private WeChatProperties weChatProperties;
    @Autowired
    private MyCache myCache;

    //定时获取access_token和jsapi_ticket
    @Scheduled(fixedDelay = 2 * 60 * 60 * 1000,initialDelay = 0)    //每次任务执行结束后延迟多久再次执行
    public void getAccessToken(){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("appid",weChatProperties.getAppid());
        paramMap.put("secret",weChatProperties.getSecret());
        paramMap.put("grant_type","client_credential");
        String json = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token", paramMap);
        log.info("获取access_token:{}",json);
        if (json == null){
            throw new BaseException("获取access_token失败");
        }
        JSONObject jsonObject = JSON.parseObject(json);
        myCache.setAccessToken(jsonObject.getString("access_token"));

        //调用微信后台获取ticket
        Map<String, String> map = new HashMap<>();
        map.put("access_token", myCache.getAccessToken());
        map.put("type","jsapi");
        String s = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", map);
        log.info("获取jsapi_ticket：{}",s);
        JSONObject jo = JSON.parseObject(s);
        if (s == null){
            throw new BaseException("获取jsapi_ticket失败");
        }else if (jo.getInteger("errcode") != 0){
            throw new BaseException(s);
        }
        myCache.setJsapiTicket(jo.getString("ticket"));
    }

}
