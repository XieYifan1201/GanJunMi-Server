package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 学员ID列表DTO（用于证书颁发）
 * 用于批量颁发证书操作
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员ID列表-证书颁发")
public class StudentIdsDTO1 {

    /** 培训期次ID */
    @ApiModelProperty("期数id")
    private int trainsId;
    
    /** 培训班次ID */
    @ApiModelProperty("班级id")
    private int trainsClassId;

    /** 学员报名ID列表 */
    @ApiModelProperty("学员报名id")
    List<Integer> ids;
}
