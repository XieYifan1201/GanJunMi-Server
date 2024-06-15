package com.train.entity;

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
public class Certificate implements Serializable {

    //数据库Certificate表的实体类

    private Long id;
    private String title;
    private LocalDateTime startdate;
    private Double expiredYear;
    private String trainUnit;

}
