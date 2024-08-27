package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoVo {

    @ApiModelProperty("学员id")
    private Long id;
    private String name;
    private String sex;
    private String idCard;
    private String phone;
    @ApiModelProperty("担任职务")
    private String duties;
    @ApiModelProperty("工作单位")
    private String workUnit;
    private String address;
    @ApiModelProperty("学员开票信息id")
    private int invoiceId;
    @ApiModelProperty("图片路径")
    private String image;
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
