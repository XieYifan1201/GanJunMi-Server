package com.train.dto;

import lombok.Data;

//草稿箱参数
@Data
public class DraftAddDTO {

    private String title;
    private String author;
    private String digest;
    private String content;
    private String content_source_url;
    private String thumb_media_id;
    private int need_open_comment; // 或者使用布尔类型Boolean，取决于API的具体要求
    private int only_fans_can_comment; // 同上
    private String pic_crop_235_1; // 注意命名可能需要调整以符合Java命名规范，例如picCrop235x1
    private String pic_crop_1_1; // 同上

}
