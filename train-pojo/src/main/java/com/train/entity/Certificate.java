package com.train.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Certificate implements Serializable {

    //数据库Certificate表的实体类

    private int id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String trainUnit;
    private Integer trainsInfoId;

}
