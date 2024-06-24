package com.train.controller;

import com.train.dto.JsapiTicketVO;
import com.train.result.Result;
import com.train.service.AuthorizationService;
import com.train.task.MyTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@Api(tags = "授权相关接口")
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private MyTask myTask;

    @ApiOperation("获取jsapi_ticket签名")
    @PostMapping("/getWxConfig")
    public Result getWxConfig(@RequestBody JsapiTicketVO jsapiTicketVO){
        log.info("获取jsapi_ticket签名:{}",jsapiTicketVO);
        Map<String,String> map = authorizationService.getTicketSig(jsapiTicketVO.getUrl());
        return Result.success(map);
    }

    @ApiOperation("重新获取access_token和jsapi_ticket")
    @GetMapping("/refresh/jsapi_ticket")
    public Result refreshJT(){
        myTask.getAccessToken();
        return Result.success();
    }

}
