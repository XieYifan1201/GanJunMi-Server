package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 草稿箱更新DTO
 * 用于更新微信公众号草稿箱中的文章
 */
@Data
@ApiModel("草稿箱更新请求参数")
public class DraftUpdateDTO {
    
    /** 素材ID */
    @ApiModelProperty("素材ID")
    private String media_id;
    
    /** 文章索引 */
    @ApiModelProperty("文章索引")
    private int index;
    
    /** 文章内容 */
    @ApiModelProperty("文章内容")
    private DraftAddDTO articles;
}
