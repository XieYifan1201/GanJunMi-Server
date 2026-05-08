package com.train.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;

/**
 * 阿里云OSS文件上传工具类
 */
@Data
@AllArgsConstructor
@Slf4j
public class AliOssUtil {

    /** OSS服务端点 */
    private String endpoint;
    
    /** 访问密钥ID */
    private String accessKeyId;
    
    /** 访问密钥Secret */
    private String accessKeySecret;
    
    /** 存储空间名称 */
    private String bucketName;

    /**
     * 文件上传到阿里云OSS
     * @param bytes 文件字节数组
     * @param objectName 文件在OSS中的名称
     * @return 文件访问URL
     */
    public String upload(byte[] bytes, String objectName) {
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 上传文件
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(bytes));
        } catch (OSSException oe) {
            log.error("OSS服务异常, ErrorCode:{}, ErrorMessage:{}, RequestId:{}, HostId:{}",
                    oe.getErrorCode(), oe.getErrorMessage(), oe.getRequestId(), oe.getHostId());
            throw new RuntimeException("文件上传失败", oe);
        } catch (ClientException ce) {
            log.error("客户端异常, ErrorMessage:{}", ce.getMessage());
            throw new RuntimeException("文件上传失败", ce);
        } finally {
            // 关闭OSSClient
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        // 构建文件访问URL: https://BucketName.Endpoint/ObjectName
        String fileUrl = String.format("https://%s.%s/%s", bucketName, endpoint, objectName);
        log.info("文件上传成功: {}", fileUrl);

        return fileUrl;
    }
}
