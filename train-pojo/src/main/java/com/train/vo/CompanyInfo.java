package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfo {

    @ApiModelProperty("发票抬头")
    private String invoiceHead;
    @ApiModelProperty("开户行")
    private String bankName;
    @ApiModelProperty("银行账户")
    private String bangNo;
    @ApiModelProperty("单位电话")
    private String unitPhone;
    @ApiModelProperty("单位地址")
    private String unitAddress;

}
