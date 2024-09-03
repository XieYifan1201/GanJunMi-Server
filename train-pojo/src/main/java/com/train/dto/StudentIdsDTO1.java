package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentIdsDTO1 {

    //颁发证书使用的接口

    @ApiModelProperty("期数id")
    private int trainsId;
    @ApiModelProperty("班级id")
    private int trainsClassId;

    @ApiModelProperty("学员报名id")
    List<Integer> ids;

}
