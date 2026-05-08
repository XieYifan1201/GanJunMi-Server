package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公司信息VO
 * 返回给前端的公司开票信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公司开票信息")
public class CompanyInfo {

    /** 发票抬头 */
    @ApiModelProperty("发票抬头")
    private String invoiceHead;
    
    /** 开户银行 */
    @ApiModelProperty("开户行")
    private String bankName;
    
    /** 银行账号 */
    @ApiModelProperty("银行账户")
    private String bangNo;
    
    /** 单位电话 */
    @ApiModelProperty("单位电话")
    private String unitPhone;
    
    /** 单位地址 */
    @ApiModelProperty("单位地址")
    private String unitAddress;
}
