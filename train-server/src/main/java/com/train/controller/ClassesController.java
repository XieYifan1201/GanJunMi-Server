package com.train.controller;

import com.train.dto.*;
import com.train.entity.Certificate;
import com.train.entity.TrainsClass;
import com.train.result.PageResult;
import com.train.result.Result;
import com.train.service.ClassesService;
import com.train.vo.TrainsClassVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 培训班次控制器
 * 处理培训期次、班次管理、报名控制等业务
 */
@RestController
@Api(tags = "开班相关接口")
@Slf4j
@RequestMapping("/api/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    /**
     * 添加培训期次信息
     * @param trainsInfoDTO 期次信息
     * @return 操作结果
     */
    @ApiOperation("添加培训期数信息(id参数都不需要传递)")
    @PostMapping("/add")
    public Result setClasses(@RequestBody TrainsInfoDTO trainsInfoDTO) {
        log.info("添加开班信息:{}",trainsInfoDTO);
        classesService.addClasses(trainsInfoDTO);
        return Result.success();
    }

    /**
     * 给期次添加班次信息
     * @param trainsClassDTO 班次信息
     * @return 操作结果
     */
    @ApiOperation("给期数添加班次信息")
    @PostMapping("/addClasses")
    public Result addClasses(@RequestBody TrainsClassDTO trainsClassDTO){
        log.info("给期数添加班次信息:{}",trainsClassDTO);
        classesService.addClass(trainsClassDTO);
        return Result.success();
    }

    /**
     * 删除培训期次信息（慎用）
     * @param id 期次ID
     * @return 操作结果
     */
    @ApiOperation("删除培训期数信息(慎用!!!)")
    @GetMapping("/delete")
    public Result delete(int id){
        log.info("删除培训期数信息:{}",id);
        classesService.delete(id);
        return Result.success();
    }

    /**
     * 删除班次信息（慎用）
     * @param trainsClassId 班次ID
     * @return 操作结果
     */
    @ApiOperation("删除班次信息(慎用!!!)")
    @GetMapping("/deleteByTrainsClassId")
    public Result deleteByTrainsClassId(int trainsClassId){
        log.info("删除班次信息:{}",trainsClassId);
        classesService.deleteByTrainsClassId(trainsClassId);
        return Result.success();
    }

    /**
     * 修改培训期次信息
     * @param trainsInfoDTO 期次信息
     * @return 操作结果
     */
    @ApiOperation("修改培训期数信息")
    @PostMapping("/update")
    public Result update(@RequestBody TrainsInfoDTO trainsInfoDTO){
        log.info("修改培训期数信息:{}",trainsInfoDTO);
        classesService.updateClasses(trainsInfoDTO);
        return Result.success();
    }

    /**
     * 修改班次信息
     * @param trainsClass 班次信息
     * @return 操作结果
     */
    @ApiOperation("修改班次信息")
    @PostMapping("/updateClasses")
    public Result updateClasses(@RequestBody TrainsClassDTO1 trainsClass){
        log.info("修改班次信息:{}",trainsClass);
        classesService.updateClass(trainsClass);
        return Result.success();
    }

    /**
     * 分页查询期次信息
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @ApiOperation("分页查询期数信息")
    @PostMapping("/getInfo")
    public Result<PageResult> getByBatch(@RequestBody ClassesPageQueryDTO pageQueryDTO){
        log.info("分页查询期数信息:{}",pageQueryDTO);
        PageResult pageResult = classesService.getByBatch(pageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据期次ID获取班次信息
     * @param id 期次ID
     * @return 班次信息列表
     */
    @ApiOperation("根据期数id获取班次信息")
    @GetMapping("/getByTrainsId")
    public Result<List<TrainsClassVO>> getByTrainsId(int id){
        log.info("根据期数id获取班次信息:{}",id);
        return Result.success(classesService.getByTrainsId(id));
    }

    /**
     * 开启或关闭报名
     * @param id 期次ID
     * @param isStart 是否允许报名
     * @return 操作结果
     */
    @ApiOperation("开启关闭报名")
    @GetMapping("/setStart")
    public Result setStart(int id,boolean isStart){
        log.info("开启关闭报名:{},{}",id,isStart);
        classesService.setStart(id,isStart);
        return Result.success();
    }

    /**
     * 给这期培训添加或修改证书信息
     * @param certificateDTO 证书信息
     * @return 操作结果
     */
    @ApiOperation("给这期培训添加/修改证书信息")
    @PostMapping("/setCertificate")
    public Result setCertificate(@RequestBody CertificateDTO certificateDTO){
        log.info("给这期培训添加/修改证书信息:{}",certificateDTO);
        classesService.save(certificateDTO);
        return Result.success();
    }

    /**
     * 获取这期培训的证书信息
     * @param trainsInfoId 期次ID
     * @return 证书信息
     */
    @ApiOperation("获取这期培训的证书信息")
    @GetMapping("/getCertificate")
    public Result<Certificate> getCertificate(int trainsInfoId){
        log.info("获取这期证书信息:{}",trainsInfoId);
        return Result.success(classesService.getCertificate(trainsInfoId));
    }

    /**
     * 获取报名班次的学员信息
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @ApiOperation("获取报名班次的学员信息")
    @PostMapping("/getStudents")
    public Result<PageResult> getStudentByTrainsClassId(@RequestBody StudentByClassDTO pageQueryDTO){
        log.info("获取报名班次的学员信息:{}",pageQueryDTO);
        PageResult pageResult = classesService.getStudentByTrainsClassId(pageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 获取报名班级的总人数
     * @param trainsClassId 班次ID
     * @return 班级人数
     */
    @ApiOperation("获取报名班级的总人数")
    @GetMapping("/getClassCount")
    public Result<Integer> getClassCount(int trainsClassId){
        return Result.success(classesService.getClassCount(trainsClassId));
    }

    /**
     * 管理员取消学员报名
     * @param studentCertificateId 报名记录ID
     * @return 操作结果
     */
    @ApiOperation("管理员取消学员报名")
    @GetMapping("/cancelSign")
    public Result deleteByStudentCertificate(int studentCertificateId){
        classesService.deleteByStudentCertificate(studentCertificateId);
        return Result.success();
    }

    /**
     * 分页获取班次信息
     * @param pageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @ApiOperation("分页获取班次信息")
    @PostMapping("/getClassInfos")
    public Result<PageResult> getClassInfo(@RequestBody PageQueryDTO pageQueryDTO){
        log.info("分页获取班次信息:{}",pageQueryDTO);
        return Result.success(classesService.getClassInfo(pageQueryDTO));
    }

}
