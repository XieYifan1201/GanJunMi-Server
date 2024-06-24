package com.train.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersCertificate implements Serializable {

    //数据库UsersCertificate实体类
    private Long id;
    private String name;
    private String idCard;
    private String cerNumber;
    private Long certificateId;
    private String image;

}
