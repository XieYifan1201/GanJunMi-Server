package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 批量获取草稿DTO
 * 用于批量获取微信公众号草稿箱中的文章列表
 */
@Data
@ApiModel("批量获取草稿请求参数")
public class DraftGetBatchDTO {

    /** 偏移量，从0开始 */
    @ApiModelProperty("偏移量")
    private int offset;
    
    /** 获取数量 */
    @ApiModelProperty("获取数量")
    private int count;
    
    /** 是否获取内容：0-不获取内容，1-获取内容 */
    @ApiModelProperty("是否获取内容")
    private int no_content;
}
