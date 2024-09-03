package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificateDTO {
    @ApiModelProperty("证书名称")
    private String title;
    @ApiModelProperty("证书有效开始日期")
    private LocalDate startDate;
    @ApiModelProperty("证书有效年限")
    private String deadline;
    @ApiModelProperty("颁证单位")
    private String trainUnit;
    @ApiModelProperty("培训期数ID")
    private Integer trainsInfoId;

}
