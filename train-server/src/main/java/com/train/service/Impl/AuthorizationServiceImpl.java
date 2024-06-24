package com.train.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.train.cache.MyCache;
import com.train.exception.BaseException;
import com.train.service.AuthorizationService;
import com.train.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private MyCache myCache;

    /**
     * 获取jsapi_ticket签名
     * @return
     */
    @Override
    public Map<String, String> getTicketSig(String url) {
        //获取ticket
        String ticket = myCache.getJsapiTicket();
        //
        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳
        //将参数排序并拼接字符串
        String str = "jsapi_ticket="+ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
        String signature = SHA1(str);
        Map<String, String> map = new HashMap<>();
        map.put("noncestr",noncestr);
        map.put("timestamp",timestamp);
        map.put("signature",signature);
        return map;
    }




    //SHA1算法加密
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


}
