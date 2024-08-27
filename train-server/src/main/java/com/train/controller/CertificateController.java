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


    /*
    @PostMapping("/save")
    @ApiOperation("添加证书")
    public Result save(@RequestBody CertificateDTO certificateDTO){
        log.info("添加证书:{}",certificateDTO);
        certificateService.save(certificateDTO);
        return Result.success();
    }

    @GetMapping("/pageQuery")
    @ApiOperation("证书分页查询")
    public Result<PageResult> pageQuery(UserPageQueryDTO pageQueryDTO){
        log.info("证书分页查询:{}",pageQueryDTO);
        PageResult pageResult = certificateService.pageQuery(pageQueryDTO);
        return Result.success(pageResult);
    }

    @PutMapping("/update")
    @ApiOperation("修改证书")
    public Result update(@RequestBody CertificateDTO certificateDTO){
        log.info("修改证书:{}",certificateDTO);
        certificateService.update(certificateDTO);
        return Result.success();
    }

    @ApiOperation("删除证书")
    @GetMapping("/delete")
    public Result delete(Long id){
        log.info("删除证书：{}",id);
        certificateService.delete(id);
        return Result.success();
    }
     */

}

