package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceInfo {

    private int id;
    @ApiModelProperty("发票抬头")
    private String invoiceHead;
    @ApiModelProperty("发票税号")
    private String invoiceNo;
    @ApiModelProperty("开户银行")
    private String bankName;
    @ApiModelProperty("银行账号")
    private String bangNo;
    @ApiModelProperty("公司地址")
    private String unitAddress;
    @ApiModelProperty("公司电话")
    private String unitPhone;
    @ApiModelProperty("是否为增值税发票")
    private boolean isSpecial;

}
