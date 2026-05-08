package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * JSAPI票据请求DTO
 * 用于获取微信JSAPI签名所需票据
 */
@Data
@ApiModel("JSAPI票据请求参数")
public class JsapiTicketVO {
    
    /** 请求页面URL */
    @ApiModelProperty("请求页面URL")
    String url;
}
