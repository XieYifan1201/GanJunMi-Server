package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecialCertificate {

    @ApiModelProperty("报名ID")
    private Integer id;
    @ApiModelProperty("特殊的证书内容")
    private String content;


}
