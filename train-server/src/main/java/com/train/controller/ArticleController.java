package com.train.controller;

import com.train.dto.*;
import com.train.result.Result;
import com.train.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(tags = "文章相关接口")
@Slf4j
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("新增永久素材")
    @PostMapping("/uploadimg")
    public Result<String> uploadimg(MultipartFile image,String type){
        log.info("上传图文消息内的图片获取URL.{}",image);
        String url = articleService.uploadimg(image,type);

        return Result.success(url);
    }

    @ApiOperation("新建草稿")
    @PostMapping("/add")
    public Result<String> add(@RequestBody List<DraftAddDTO> dtoList){
        log.info("新建草稿");
        String media_id = articleService.add(dtoList);

        return Result.success(media_id);
    }

    @ApiOperation("获取草稿")
    @PostMapping("/get")
    public Result<String> get(@RequestBody DraftGetDTO getDTO){
        log.info("获取草稿,{}",getDTO);
        String json = articleService.get(getDTO);

        return Result.success(json);
    }

    @ApiOperation("删除草稿")
    @PostMapping("/delete")
    public Result<String> delete(@RequestBody DraftGetDTO getDTO){
        log.info("删除草稿,{}",getDTO);
        String s = articleService.delete(getDTO);

        return Result.success(s);
    }

    @ApiOperation("修改草稿")
    @PostMapping("/update")
    public Result<String> update(@RequestBody DraftUpdateDTO draftUpdateDTO){
        log.info("修改草稿.{}",draftUpdateDTO);

        String s = articleService.update(draftUpdateDTO);
        return Result.success(s);
    }

    @ApiOperation("获取草稿列表")
    @PostMapping("/batchget")
    public Result<String> batchget(@RequestBody DraftGetBatchDTO getBatchDTO){
        log.info("获取草稿列表,{}",getBatchDTO);
        String s = articleService.getBatch(getBatchDTO);
        return Result.success(s);
    }

    @PostMapping("/submit")
    @ApiOperation("发布文章")
    public Result<String> submit(@RequestBody DraftGetDTO dto){
        log.info("发布文章:{}",dto);
        String s = articleService.submit(dto);
        return Result.success(s);
    }

    @ApiOperation("发布状态轮询")
    @PostMapping("/getState")
    public Result<String> getState(@RequestBody DraftGetDTO dto){
        log.info("发布状态轮询:{}",dto);
        String s = articleService.getState(dto);
        return Result.success(s);
    }

    @ApiOperation("删除发布")
    @PostMapping("/delArticle")
    public Result<String> delArticle(@RequestBody ArticleDelDTO delDTO){
        log.info("删除发布:{}",delDTO);
        String s = articleService.delArticle(delDTO);
        return Result.success(s);
    }

    @ApiOperation("通过 article_id 获取已发布文章")
    @PostMapping("/getarticle")
    public Result<String> getarticle(@RequestBody DraftGetDTO dto){
        log.info("通过 article_id 获取已发布文章:{}",dto);
        String s = articleService.getarticle(dto);

        return Result.success();
    }

    @ApiOperation("获取成功发布列表")
    @PostMapping("/getArticleBatch")
    public Result<String> articleBatchGet(@RequestBody DraftGetBatchDTO batchDTO){
        log.info("获取成功发布列表:{}",batchDTO);
        String s = articleService.articleBatchGet(batchDTO);
        return Result.success(s);
    }

}
