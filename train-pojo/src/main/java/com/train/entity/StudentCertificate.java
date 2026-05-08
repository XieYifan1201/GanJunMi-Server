package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学员证书关联实体类
 * 对应数据库 student_certificate 表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCertificate {

    /** 记录ID */
    private int id;
    
    /** 学员ID */
    private Long studentId;
    
    /** 培训班次ID */
    private int trainsClassId;
    
    /** 是否已颁发证书 */
    private boolean isCertificate;
    
    /** 证书编号 */
    private String CertificateNo;
    
    /** 证书模板ID */
    private int certificateId;
    
    /** 二维码路径 */
    private String QRcode;
    
    /** 颁发日期 */
    private LocalDateTime date;
    
    /** 是否已支付 */
    private boolean pay;
    
    /** 收据ID */
    private Long receipt;

    /** 特殊证书内容 */
    private String special_content;
    
    /** 收据文件路径 */
    private String receiptPath;
}
