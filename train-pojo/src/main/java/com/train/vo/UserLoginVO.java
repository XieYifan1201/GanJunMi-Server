package com.train.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO implements Serializable {

    private String token;
    private Integer roleId;
    private String name;
    private String idCard;
    private String phone;
    private String sex;
    private String image;
    private Long id;
}
