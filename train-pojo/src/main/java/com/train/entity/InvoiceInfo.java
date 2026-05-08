package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发票信息实体类
 * 对应数据库 invoice_info 表
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceInfo {

    /** 发票信息ID */
    private int id;
    
    /** 发票抬头 */
    @ApiModelProperty("发票抬头")
    private String invoiceHead;
    
    /** 发票税号 */
    @ApiModelProperty("发票税号")
    private String invoiceNo;
    
    /** 开户银行 */
    @ApiModelProperty("开户银行")
    private String bankName;
    
    /** 银行账号 */
    @ApiModelProperty("银行账号")
    private String bangNo;
    
    /** 公司地址 */
    @ApiModelProperty("公司地址")
    private String unitAddress;
    
    /** 公司电话 */
    @ApiModelProperty("公司电话")
    private String unitPhone;
    
    /** 是否为增值税发票 */
    @ApiModelProperty("是否为增值税发票")
    private boolean isSpecial;
}
