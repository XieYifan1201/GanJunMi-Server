package com.train.controller;

import com.train.dto.*;
import com.train.entity.Student;
import com.train.entity.StudentCertificate;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.StudentService;
import com.train.vo.ApplyInfo;
import com.train.vo.CertificateVO;
import com.train.vo.SignVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学员控制器
 * 处理学员报名、信息管理、证书颁发等业务
 */
@RestController
@Slf4j
@Api(tags = "学员相关接口")
@RequestMapping("/api/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    /**
     * 学员报名接口
     * @param signDTO 报名信息
     * @return 操作结果
     */
    @ApiOperation("学员报名")
    @PostMapping("/sign")
    public Result sign(@RequestBody SignDTO signDTO){
        log.info("学员报名信息:{}",signDTO);
        studentService.sign(signDTO);
        return Result.success();
    }

    /**
     * 管理员添加或修改学员报名信息
     * @param signDTO1 报名信息
     * @return 操作结果
     */
    @ApiOperation("添加/修改学员报名信息")
    @PostMapping("/SAUpdateSign")
    public Result SAUpdateSign(@RequestBody SignDTO1 signDTO1){
        log.info("添加/修改学员报名信息:{}",signDTO1);
        studentService.SAUpdateSign(signDTO1);
        return Result.success();
    }

    /**
     * 管理员添加学员信息
     * @param student 学员信息
     * @return 操作结果
     */
    @ApiOperation("添加学员信息")
    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        log.info("添加学员信息:{}",student);
        studentService.add(student);
        return Result.success();
    }

    /**
     * 学员获取自己的报名信息
     * @return 报名信息
     */
    @PostMapping("/signInfo")
    @ApiOperation("学员获得自己报名信息")
    public Result<SignVO> signInfo(){
        log.info("学员获得自己报名信息");
        return Result.success(studentService.signInfo());
    }

    /**
     * 根据ID获取学员信息
     * @param id 学员ID
     * @return 学员信息
     */
    @ApiOperation("根据id获取学员信息")
    @GetMapping("/getById")
    public Result getById(Long id){
        log.info("获取学员信息:{}",id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 修改学员信息
     * @param student 学员信息
     * @return 操作结果
     */
    @ApiOperation("修改学员信息")
    @PostMapping("/update")
    public Result update(@RequestBody Student student){
        log.info("修改学员信息:{}",student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 删除学员信息
     * @param id 学员ID
     * @return 操作结果
     */
    @ApiOperation("删除学员信息")
    @GetMapping("/delete")
    public Result delete(Long id){
        log.info("删除学员信息:{}",id);
        studentService.delete(id);
        return Result.success();
    }

    /**
     * 分页查询学员信息
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @ApiOperation("分页查询学员信息")
    @PostMapping("/getByBatch")
    public Result<PageResult> getByBatch(@RequestBody StudentPageQueryDTO pageQueryDTO){
        log.info("分页查询学员信息:{}",pageQueryDTO);
        return Result.success(studentService.getByBatch(pageQueryDTO));
    }

    /**
     * 分页查询学员信息（包含发票信息）
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @ApiOperation("分页查询学员信息(包含发票信息)")
    @PostMapping("/getByBatch1")
    public Result<PageResult> getByBatch1(@RequestBody StudentInvoicePageQueryDTO pageQueryDTO){
        log.info("分页查询学员信息(包含发票信息):{}",pageQueryDTO);
        return Result.success(studentService.getByBatch1(pageQueryDTO));
    }

    /**
     * 分页查询学员信息（包含班次信息）
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @ApiOperation("分页查询学员信息(包含班次信息)")
    @PostMapping("/getByBatch2")
    public Result<PageResult> getByBatch2(@RequestBody StudentPageQueryDTO pageQueryDTO){
        log.info("分页查询学员信息(包含班次信息)：{}",pageQueryDTO);
        return Result.success(studentService.getByBatch2(pageQueryDTO));
    }

    /**
     * 给学员颁发证书
     * 生成证书编号和二维码
     * @param studentIdsDTO1 学员ID列表
     * @param request HTTP请求对象
     * @return 操作结果
     */
    @ApiOperation("给学员颁发证书颁发证书")
    @PostMapping("/issueCertificate")
    public Result issueCertificate(@RequestBody StudentIdsDTO1 studentIdsDTO1,HttpServletRequest request){
        log.info("给学员颁发证书:{}",studentIdsDTO1);
        // 返回图片路径
        String imgPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + "files/qrcode/";
        studentService.issueCertificate(studentIdsDTO1,imgPath);
        return Result.success();
    }

    /**
     * 获取学员证书信息
     * @param studentIdsDTO 学员ID列表
     * @return 证书信息列表
     */
    @ApiOperation("获取学员证书信息")
    @PostMapping("/getCertificate")
    public Result<List<CertificateVO>> getCertificate(@RequestBody StudentIdsDTO studentIdsDTO){
        log.info("获取学员证书信息:{}",studentIdsDTO);
        List<CertificateVO> list = studentService.getCertificate(studentIdsDTO);
        return Result.success(list);
    }

    /**
     * 学员撤销报名
     * @param id 报名记录ID
     * @return 操作结果
     */
    @ApiOperation("撤销报名")
    @GetMapping("/cancelSign")
    public Result cancelSign(int id){
        log.info("撤销报名:{}",id);
        studentService.cancelSign(id);
        return Result.success();
    }

    /**
     * 获取学员的报名次数
     * @param id 学员ID
     * @return 报名次数
     */
    @ApiOperation("获取学员的报名次数")
    @GetMapping("/getCount")
    public Result<Integer> getCount(Long id){
        log.info("获取学员的报名次数:{}",id);
        return Result.success(studentService.getCount(id));
    }

    /**
     * 修改学员的缴费状态
     * @param state 缴费状态参数
     * @return 操作结果
     */
    @ApiOperation("修改学员的缴费状态")
    @PostMapping("/updatePayStatus")
    public Result updatePayStatus(@RequestBody PayState state){
        log.info("修改学员报名信息:{},{}",state);
        studentService.updatePayStatus(state);
        return Result.success();
    }

    /**
     * 添加或修改个别学员的特殊证书内容
     * @param certificate 特殊证书信息
     * @return 操作结果
     */
    @ApiOperation("个别学员证书内容添加/修改")
    @PostMapping("/addCertificateContent")
    public Result addCertificateContent(@RequestBody SpecialCertificate certificate){
        log.info("个别学员证书内容添加:{}",certificate);
        studentService.addCertificateContent(certificate);
        return Result.success();
    }

    /**
     * 获取当前账号的所有报名信息
     * @return 报名信息列表
     */
    @GetMapping("/getAllApplyInfo")
    @ApiOperation("获取该账号的所有报名信息")
    public Result<List<ApplyInfo>> getAllApplyInfo(){
        log.info("获取该账号的所有报名信息");
        return Result.success(studentService.getAllApplyInfo());
    }

}
