package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 支付状态DTO
 * 用于批量更新学员支付状态
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("支付状态")
public class PayState {

    /** 学员证书ID列表 */
    @ApiModelProperty("学员证书ID列表")
    List<Integer> ids;

    /** 支付状态 */
    @ApiModelProperty("支付状态")
    boolean payStatue;
}
