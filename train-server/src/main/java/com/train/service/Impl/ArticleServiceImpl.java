package com.train.service.Impl;

import com.alibaba.fastjson.JSON;
import com.train.cache.MyCache;
import com.train.context.BaseContext;
import com.train.dto.*;
import com.train.exception.BaseException;
import com.train.mapper.UserMapper;
import com.train.service.ArticleService;
import com.train.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private MyCache myCache;
    @Autowired
    private UserMapper userMapper;

    /**
     * 上传图文消息内的图片获取URL
     * @param image
     * @return
     */
    @Override
    public String uploadimg(MultipartFile image,String type) {
        int roleId = userMapper.getById(BaseContext.getCurrentId()).getRoleId();
        if (roleId < 3){
            String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + myCache.getAccessToken() + "&type=" + type;

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost(url);

                // TODO 注意：这里我们假设文件不是太大，可以读入到内存中。对于大文件，可能需要使用其他方法。
                byte[] fileBytes = image.getBytes();
                HttpEntity multipart = MultipartEntityBuilder.create()
                        .addBinaryBody("media", fileBytes, ContentType.APPLICATION_OCTET_STREAM, image.getOriginalFilename())
                        .build();

                httpPost.setEntity(multipart);

                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                    return result; // 返回微信API的响应
                }
            } catch (IOException e) {
                throw new BaseException("文件上传失败");
            }
        }else {
            throw new BaseException("权限不足");
        }
    }

    /**
     * 新建草稿
     * @param dtoList
     */
    @Override
    public String add(List<DraftAddDTO> dtoList) {
        String url = "https://api.weixin.qq.com/cgi-bin/draft/add?access_token=" + myCache.getAccessToken();

        Map<String,List<DraftAddDTO>> map = new HashMap<>();
        map.put("articles",dtoList);
        String jsonString = JSON.toJSONString(map);
        log.info(jsonString);
        try {
            return HttpClientUtil.doPostJson(url, jsonString);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 获取草稿
     * @param getDTO
     * @return
     */
    @Override
    public String get(DraftGetDTO getDTO) {
        String url = "https://api.weixin.qq.com/cgi-bin/draft/get?access_token=" + myCache.getAccessToken();
        Map<String,String> map = new HashMap<>();
        map.put("media_id",getDTO.getId());
        log.info(map.toString());
        try {
            return HttpClientUtil.doPost4Json(url, map);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 删除草稿
     * @param getDTO
     */
    @Override
    public String delete(DraftGetDTO getDTO) {
        String url = "https://api.weixin.qq.com/cgi-bin/draft/delete?access_token=" + myCache.getAccessToken();

        Map<String,String> map = new HashMap<>();
        map.put("media_id",getDTO.getId());
        log.info(map.toString());
        try {
            return HttpClientUtil.doPost4Json(url, map);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 修改草稿
     * @param draftUpdateDTO
     * @return
     */
    @Override
    public String update(DraftUpdateDTO draftUpdateDTO) {
        String url = "https://api.weixin.qq.com/cgi-bin/draft/update?access_token=" + myCache.getAccessToken();

        String jsonString = JSON.toJSONString(draftUpdateDTO);
        log.info(jsonString);
        try {
            return HttpClientUtil.doPostJson(url, jsonString);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 获取草稿列表
     * @param getBatchDTO
     * @return
     */
    @Override
    public String getBatch(DraftGetBatchDTO getBatchDTO) {
        String url = "https://api.weixin.qq.com/cgi-bin/draft/batchget?access_token=" + myCache.getAccessToken();

        String jsonString = JSON.toJSONString(getBatchDTO);
        log.info(jsonString);
        try {
            return HttpClientUtil.doPostJson(url, jsonString);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 发布文章
     * @param dto
     * @return
     */
    @Override
    public String submit(DraftGetDTO dto) {
        String url = "https://api.weixin.qq.com/cgi-bin/freepublish/submit?access_token=" + myCache.getAccessToken();

        Map<String,String> map = new HashMap<>();
        map.put("media_id",dto.getId());
        log.info(map.toString());
        try {
            return HttpClientUtil.doPost4Json(url, map);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 发布状态轮询
     * @param dto
     * @return
     */
    @Override
    public String getState(DraftGetDTO dto) {
        String url = "https://api.weixin.qq.com/cgi-bin/freepublish/get?access_token=" + myCache.getAccessToken();

        Map<String,String> map = new HashMap<>();
        map.put("publish_id",dto.getId());
        log.info(map.toString());
        try {
            return HttpClientUtil.doPost4Json(url, map);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 删除发布
     * @param delDTO
     * @return
     */
    @Override
    public String delArticle(ArticleDelDTO delDTO) {
        String url = "https://api.weixin.qq.com/cgi-bin/freepublish/delete?access_token=" + myCache.getAccessToken();

        String jsonString = JSON.toJSONString(delDTO);
        log.info(jsonString);
        try {
            return HttpClientUtil.doPostJson(url, jsonString);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 通过 article_id 获取已发布文章
     * @param dto
     * @return
     */
    @Override
    public String getarticle(DraftGetDTO dto) {
        String url = "https://api.weixin.qq.com/cgi-bin/freepublish/getarticle?access_token=" + myCache.getAccessToken();

        Map<String,String> map = new HashMap<>();
        map.put("article_id",dto.getId());
        log.info(map.toString());
        try {
            return HttpClientUtil.doPost4Json(url, map);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }

    /**
     * 获取成功发布列表
     * @param batchDTO
     * @return
     */
    @Override
    public String articleBatchGet(DraftGetBatchDTO batchDTO) {
        String url = "https://api.weixin.qq.com/cgi-bin/freepublish/batchget?access_token=" + myCache.getAccessToken();

        String jsonString = JSON.toJSONString(batchDTO);
        log.info(jsonString);
        try {
            return HttpClientUtil.doPostJson(url, jsonString);
        } catch (IOException e) {
            throw new BaseException("请求失败" + e);
        }
    }
}
