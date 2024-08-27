package com.train.service;

import com.train.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {


    /**
     * 上传图文消息内的图片获取URL
     * @param image
     * @return
     */
    String uploadimg(MultipartFile image,String type);

    /**
     * 新建草稿
     * @param dtoList
     * return media_id
     */
    String add(List<DraftAddDTO> dtoList);

    /**
     * 获取草稿
     * @param getDTO
     * @return
     */
    String get(DraftGetDTO getDTO);

    /**
     * 删除草稿
     * @param getDTO
     */
    String delete(DraftGetDTO getDTO);

    /**
     * 修改草稿
     * @param draftUpdateDTO
     * @return
     */
    String update(DraftUpdateDTO draftUpdateDTO);

    /**
     * 获取草稿列表
     * @param getBatchDTO
     * @return
     */
    String getBatch(DraftGetBatchDTO getBatchDTO);

    /**
     * 发布文章
     * @param dto
     * @return
     */
    String submit(DraftGetDTO dto);

    /**
     * 发布状态轮询
     * @param dto
     * @return
     */
    String getState(DraftGetDTO dto);

    /**
     * 删除发布
     * @param delDTO
     * @return
     */
    String delArticle(ArticleDelDTO delDTO);

    /**
     * 通过 article_id 获取已发布文章
     * @param dto
     * @return
     */
    String getarticle(DraftGetDTO dto);

    /**
     * 获取成功发布列表
     * @param batchDTO
     * @return
     */
    String articleBatchGet(DraftGetBatchDTO batchDTO);
}
