package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 学员ID列表DTO
 * 用于批量操作学员信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员ID列表")
public class StudentIdsDTO {

    /** 学员报名ID列表 */
    @ApiModelProperty("学员报名id")
    List<Integer> ids;
}
