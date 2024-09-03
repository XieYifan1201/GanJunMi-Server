package com.train.controller;

import com.train.dto.*;
import com.train.entity.Student;
import com.train.entity.StudentCertificate;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.StudentService;
import com.train.vo.CertificateVO;
import com.train.vo.SignVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@Api(tags = "学员相关接口")
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("学员报名")
    @PostMapping("/sign")
    public Result sign(@RequestBody SignDTO signDTO){
        log.info("学员报名信息:{}",signDTO);

        studentService.sign(signDTO);
        return Result.success();
    }

    @ApiOperation("添加学员信息")
    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        log.info("学员报名信息:{}",student);
        studentService.add(student);
        return Result.success();
    }

    @PostMapping("/signInfo")
    @ApiOperation("学员获得自己报名信息")
    public Result<SignVO> signInfo(){
        log.info("学员获得自己报名信息");
        return Result.success(studentService.signInfo());
    }

    @ApiOperation("根据id获取学员信息")
    @GetMapping("/getById")
    public Result getById(Long id){
        log.info("获取学员信息:{}",id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @ApiOperation("修改学员信息")
    @PostMapping("/update")
    public Result update(@RequestBody Student student){
        log.info("修改学员信息:{}",student);
        studentService.update(student);
        return Result.success();
    }

    @ApiOperation("删除学员信息")
    @GetMapping("/delete")
    public Result delete(Long id){
        log.info("删除学员信息:{}",id);
        studentService.delete(id);
        return Result.success();
    }

    @ApiOperation("分页查询学员信息")
    @PostMapping("/getByBatch")
    public Result<PageResult> getByBatch(@RequestBody StudentPageQueryDTO pageQueryDTO){
        log.info("分页查询学员信息:{}",pageQueryDTO);
        return Result.success(studentService.getByBatch(pageQueryDTO));
    }

    @ApiOperation("分页查询学员信息(包含发票信息)")
    @PostMapping("/getByBatch1")
    public Result<PageResult> getByBatch1(@RequestBody StudentInvoicePageQueryDTO pageQueryDTO){
        log.info("分页查询学员信息(包含发票信息):{}",pageQueryDTO);
        return Result.success(studentService.getByBatch1(pageQueryDTO));
    }


    @ApiOperation("给学员颁发证书颁发证书")
    @PostMapping("/issueCertificate")
    public Result issueCertificate(@RequestBody StudentIdsDTO1 studentIdsDTO1,HttpServletRequest request){
        log.info("给学员颁发证书:{}",studentIdsDTO1);
        //返回图片路径
        String imgPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + "files/qrcode/";
        studentService.issueCertificate(studentIdsDTO1,imgPath);
        return Result.success();
    }

    @ApiOperation("获取学员证书信息")
    @PostMapping("/getCertificate")
    public Result<List<CertificateVO>> getCertificate(@RequestBody StudentIdsDTO studentIdsDTO){
        log.info("获取学员证书信息:{}",studentIdsDTO);
        List<CertificateVO> list = studentService.getCertificate(studentIdsDTO);
        return Result.success(list);
    }

    @ApiOperation("撤销报名")
    @GetMapping("/cancelSign")
    public Result cancelSign(int id){
        log.info("撤销报名:{}",id);
        studentService.cancelSign(id);
        return Result.success();
    }

    @ApiOperation("获取学员的报名次数")
    @GetMapping("/getCount")
    public Result<Integer> getCount(Long id){
        log.info("获取学员的报名次数:{}",id);
        return Result.success(studentService.getCount(id));
    }

    @ApiOperation("修改学员的缴费状态")
    @GetMapping("/updatePayStatus")
    public Result updatePayStatus(int id,boolean payStatue){
        log.info("修改学员报名信息:{},{}",id,payStatue);
        studentService.updatePayStatus(id,payStatue);
        return Result.success();
    }


}
