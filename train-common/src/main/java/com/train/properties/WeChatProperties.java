package com.train.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号配置属性类
 * 从配置文件中读取train.wechat前缀的配置项
 */
@Component
@ConfigurationProperties(prefix = "train.wechat")
@Data
public class WeChatProperties {

    /** 微信公众号AppID */
    private String appid;
    
    /** 微信公众号AppSecret */
    private String secret;
}
