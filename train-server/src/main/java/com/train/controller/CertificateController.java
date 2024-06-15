package com.train.controller;

import com.train.result.Result;
import com.train.service.CertificateService;
import com.train.vo.CertificateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "证书相关接口")
@Slf4j
@RequestMapping("/api/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @ApiOperation("通过证书编号获取证书信息")
    @GetMapping("/getByNumber")
    public Result<CertificateVO> getByNumber(String number){
        log.info("证书编号：{}",number);
        CertificateVO certificateVO = certificateService.getByNumber(number);

        return Result.success(certificateVO);
    }

}
