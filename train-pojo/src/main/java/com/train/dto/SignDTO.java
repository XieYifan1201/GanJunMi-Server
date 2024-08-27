package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignDTO {

    @ApiModelProperty("培训期次id")
    private Integer trainsId;
    @ApiModelProperty("班次id")
    private Integer trainClassId;
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
    private Integer invoiceId;
    @ApiModelProperty("图片路径")
    private String image;

}
