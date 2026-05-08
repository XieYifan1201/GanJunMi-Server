package com.train.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体类
 * 对应数据库 user 表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    /** 用户ID */
    private Long id;
    
    /** 微信OpenID */
    private String openid;
    
    /** 用户姓名 */
    private String name;
    
    /** 登录密码 */
    private String password;
    
    /** 性别 */
    private String sex;
    
    /** 联系电话 */
    private String phone;
    
    /** 身份证号 */
    private String idCard;
    
    /** 角色ID */
    private Integer roleId;
    
    /** 创建时间 */
    private LocalDateTime createTime;
    
    /** 头像图片路径 */
    private String image;
}
