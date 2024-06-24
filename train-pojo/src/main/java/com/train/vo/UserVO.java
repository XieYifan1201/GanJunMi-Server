package com.train.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {
    //数据库User表实体类

    private Long id;
    private String name;
    private String sex;
    private String phone;
    private String idCard;
    private Integer roleId;
    private LocalDateTime createTime;



}
