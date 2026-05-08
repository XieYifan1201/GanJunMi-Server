package com.train.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置属性类
 * 从配置文件中读取train.jwt前缀的配置项
 */
@Component
@ConfigurationProperties(prefix = "train.jwt")
@Data
public class JwtProperties {
    
    /** JWT签名密钥 */
    private String secretKey;
    
    /** JWT令牌有效期（毫秒） */
    private Long ttl;
    
    /** JWT令牌在请求头中的名称 */
    private String tokenName;
}
