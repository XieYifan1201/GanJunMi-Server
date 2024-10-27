package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignVO {

    @ApiModelProperty("学员id")
    private Long studentId;
    private String name;
    private String sex;
    private String idCard;
    private String phone;
    @ApiModelProperty("工作单位")
    private String workUnit;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("区")
    private String district;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("图片路径")
    private String image;
    private List<SignInfo> signInfos;

}
