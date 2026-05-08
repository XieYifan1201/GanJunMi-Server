package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 草稿箱添加DTO
 * 用于微信公众号草稿箱添加操作
 */
@Data
@ApiModel("草稿箱添加请求参数")
public class DraftAddDTO {

    /** 文章标题 */
    @ApiModelProperty("文章标题")
    private String title;
    
    /** 作者 */
    @ApiModelProperty("作者")
    private String author;
    
    /** 摘要 */
    @ApiModelProperty("摘要")
    private String digest;
    
    /** 文章内容 */
    @ApiModelProperty("文章内容")
    private String content;
    
    /** 原文链接 */
    @ApiModelProperty("原文链接")
    private String content_source_url;
    
    /** 封面图素材ID */
    @ApiModelProperty("封面图素材ID")
    private String thumb_media_id;
    
    /** 是否打开评论：0-不打开，1-打开 */
    @ApiModelProperty("是否打开评论")
    private int need_open_comment;
    
    /** 是否仅粉丝可评论：0-所有人，1-仅粉丝 */
    @ApiModelProperty("是否仅粉丝可评论")
    private int only_fans_can_comment;
    
    /** 2.35:1 裁剪参数 */
    @ApiModelProperty("2.35:1裁剪参数")
    private String pic_crop_235_1;
    
    /** 1:1 裁剪参数 */
    @ApiModelProperty("1:1裁剪参数")
    private String pic_crop_1_1;
}
