package com.train.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String idCard;
    private String image;

}
