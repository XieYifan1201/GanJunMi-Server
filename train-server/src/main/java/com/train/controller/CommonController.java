package com.train.controller;

import com.alibaba.fastjson.JSON;
import com.train.cache.MyCache;
import com.train.constant.MessageConstant;
import com.train.exception.BaseException;
import com.train.result.Result;
import com.train.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@Api(tags = "通用接口")
public class CommonController {

    @Value("${web.upload-path}")
    private String path;        //图片保存和下载的路径
    @Value("${web.qrcode-path}")
    private String qrcodePath;  //二维码保存路径

    @Autowired
    private MyCache myCache;

    @PostMapping("/api/upload")
    @ApiOperation("文件上传")
    public Result upload(MultipartFile image, HttpServletRequest request) throws IOException {
        log.info("文件上传:{}",image);

        // 文件大小检查
        long fileSize = image.getSize();
        if (fileSize < 50 * 1024 || fileSize > 3 * 1024 * 1024) {
            throw new BaseException("上传文件大小需为50KB-3MB");
        }

        // 检查文件类型是否为图片
        String contentType = image.getContentType();
        if (!contentType.startsWith("image")) {
            return Result.error("上传的文件不是图片");
        }

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

    /**
     * 获取图片
     * @param filename
     * @return
     */
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

    /**
     * 获取二维码图片
     * @param filename
     * @return
     */
    @GetMapping("/files/qrcode/{filename:.+}")
    public ResponseEntity<Resource> serveFile1(@PathVariable String filename){
        Path file = Paths.get(qrcodePath).resolve(filename);
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

    @ApiOperation("获取公众号成功发布列表")
    @GetMapping("/getList")
    public Result<String> getList(String offset,String count,String no_content) throws IOException {
        log.info("获取公众号成功发布列表");

        Map<String,String> map = new HashMap();
        map.put("offset",offset);
        map.put("count",count);
        map.put("no_content",no_content);

        String json = HttpClientUtil.doPost4Json("https://api.weixin.qq.com/cgi-bin/freepublish/batchget?access_token=" + myCache.getAccessToken(), map);

        return Result.success(JSON.parseObject(json).toString());
    }


}
