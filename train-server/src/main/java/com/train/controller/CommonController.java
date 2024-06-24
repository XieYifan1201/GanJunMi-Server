package com.train.controller;

import com.train.constant.MessageConstant;
import com.train.exception.BaseException;
import com.train.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@Slf4j
@Api(tags = "通用接口")
@RequestMapping("")
public class CommonController {

    @Value("${web.upload-path}")
    private String path;        //图片保存和下载的路径

    @PostMapping("/api/upload")
    @ApiOperation("文件上传")
    public Result upload(MultipartFile image, HttpServletRequest request) throws IOException {
        log.info("文件上传:{}",image);

        //获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //获取文件后缀
        String s = originalFilename.substring(originalFilename.lastIndexOf("."));
        //避免文件命名重复
        String newFileName = UUID.randomUUID() + s;
        image.transferTo(new File(path + newFileName));

        //返回图片路径
        String imgPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + "files/" + newFileName;
        return Result.success(imgPath);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Path file = Paths.get(path).resolve(filename);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()){
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .contentType(MediaType.IMAGE_PNG)
                        .body(resource);
            }
        } catch (MalformedURLException e) {
            throw new BaseException(MessageConstant.NOT_FIND_IMG);
        }
        return ResponseEntity.notFound().build();
    }


}
