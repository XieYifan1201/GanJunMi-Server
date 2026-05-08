package com.train.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 证书实体类
 * 对应数据库 certificate 表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Certificate implements Serializable {

    /** 证书ID */
    private int id;
    
    /** 证书标题 */
    private String title;
    
    /** 培训开始日期 */
    private LocalDate startDate;
    
    /** 培训结束日期 */
    private String deadline;
    
    /** 培训单位 */
    private String trainUnit;
    
    /** 培训期次ID */
    private Integer trainsInfoId;
}
