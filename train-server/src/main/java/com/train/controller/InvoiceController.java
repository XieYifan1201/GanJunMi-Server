package com.train.controller;

import com.train.entity.InvoiceInfo;
import com.train.result.Result;
import com.train.service.InvoiceService;
import com.train.vo.CompanyInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")
@Slf4j
@Api("开票信息接口")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @ApiOperation("保存开票信息(id不需要传递)")
    @PostMapping("/saveInvoice")
    public Result<Integer> saveInvoice(@RequestBody InvoiceInfo invoiceInfo) {
        log.info("保存开票信息：{}",invoiceInfo);
        Integer id = invoiceService.saveInvoice(invoiceInfo);
        return Result.success(id);
    }

    @ApiOperation("删除开票信息")
    @GetMapping("/deleteInvoice")
    public Result deleteInvoice(int id) {
        log.info("删除开票信息：{}",id);
        invoiceService.deleteInvoice(id);
        return Result.success();
    }

    @ApiOperation("修改开票信息")
    @PostMapping("/updateInvoice")
    public Result updateInvoice(@RequestBody InvoiceInfo invoiceInfo) {
        log.info("修改开票信息：{}",invoiceInfo);
        invoiceService.updateInvoice(invoiceInfo);
        return Result.success();
    }

    @ApiOperation("根据id获取开票信息")
    @GetMapping("/getInvoiceById")
    public Result<InvoiceInfo> getInvoiceById(int id) {
        log.info("根据id获取开票信息：{}",id);
        InvoiceInfo invoiceInfo = invoiceService.getInvoiceById(id);
        return Result.success(invoiceInfo);
    }

    @ApiOperation("添加或修改开票信息")
    @PostMapping("/addOrUpdateInvoice")
    public Result addOrUpdateInvoice(@RequestBody InvoiceInfo invoiceInfo,String idCard) {
        log.info("添加或修改开票信息：{}",invoiceInfo);
        invoiceService.addOrUpdateInvoice(invoiceInfo,idCard);
        return Result.success();
    }

    @ApiOperation("根据学员id获取开票信息")
    @GetMapping("/getInvoiceByStudentId")
    public Result<InvoiceInfo> getInvoiceByStudentId(Long studentId) {
        log.info("根据id获取开票信息：{}",studentId);
        InvoiceInfo invoiceInfo = invoiceService.getInvoiceByStudentId(studentId);
        return Result.success(invoiceInfo);
    }

    @ApiOperation("根据身份证获取开票信息")
    @GetMapping("/getInvoiceByIdCard")
    public Result<InvoiceInfo> getInvoiceByIdCard(String idCard) {
        log.info("根据身份证获取开票信息：{}",idCard);
        InvoiceInfo invoiceInfo = invoiceService.getInvoiceByIdCard(idCard);
        return Result.success(invoiceInfo);
    }

    @ApiOperation("根据发票抬头查询数据库中已有的公司发票信息")
    @GetMapping("/getCompanyInfo")
    public Result<CompanyInfo> getCompanyInfo(String invoiceHead){
        log.info("根据发票抬头查询数据库中已有的公司发票信息：{}",invoiceHead);
        return Result.success(invoiceService.getCompanyInfo(invoiceHead));
    }

}
