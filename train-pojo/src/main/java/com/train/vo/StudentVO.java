package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {

    @ApiModelProperty("学员报名id")
    private int studentCertificateId;
    @ApiModelProperty("学员id")
    private Long studentId;
    private String name;
    private String sex;
    private String idCard;
    private String phone;
    @ApiModelProperty("担任职务")
    private String duties;
    @ApiModelProperty("工作单位")
    private String workUnit;
    private String address;
    @ApiModelProperty("图片路径")
    private String image;
    @ApiModelProperty("是否颁发证书")
    private boolean isCertificate;

}
