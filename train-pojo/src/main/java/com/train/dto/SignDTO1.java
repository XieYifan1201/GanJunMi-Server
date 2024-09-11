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
public class SignDTO1 {

    @ApiModelProperty("培训期次id")
    private Integer trainsId;
    @ApiModelProperty("班次id")
    private Integer trainClassId;
    @ApiModelProperty("学员id")
    private Long studentId;
    @ApiModelProperty("学员报名id")
    private Integer studentCertificateId;

}
