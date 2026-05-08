package com.train.controller;

import com.train.dto.CertificateDTO;
import com.train.dto.StudentIdsDTO;
import com.train.dto.UserPageQueryDTO;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.CertificateService;
import com.train.vo.CertificateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 证书控制器
 * 处理证书查询、验证等相关业务
 */
@RestController
@Api(tags = "证书相关接口")
@Slf4j
@RequestMapping("/api/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    /**
     * 通过证书编号查询证书信息
     * @param number 证书编号
     * @return 证书详细信息
     */
    @ApiOperation("通过证书编号获取证书信息")
    @GetMapping("/getByNumber")
    public Result<CertificateVO> getByNumber(String number){
        log.info("证书编号：{}",number);
        CertificateVO certificateVO = certificateService.getByNumber(number);
        return Result.success(certificateVO);
    }

}

