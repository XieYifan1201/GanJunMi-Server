package com.train.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP请求工具类
 * 提供GET和POST请求方法，支持表单和JSON格式数据
 */
@Slf4j
public final class HttpClientUtil {

    /** 请求超时时间（毫秒） */
    private static final int TIMEOUT_MSEC = 5 * 1000;

    private HttpClientUtil() {
        // 防止实例化
    }

    /**
     * 发送GET请求
     * @param url 请求地址
     * @param paramMap 请求参数
     * @return 响应内容
     */
    public static String doGet(String url, Map<String, String> paramMap) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";

        try {
            // 构建带参数的URI
            URIBuilder builder = new URIBuilder(url);
            if (paramMap != null) {
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            URI uri = builder.build();

            // 创建GET请求并执行
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);

            // 判断响应状态
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            log.error("发送GET请求失败, url:{}", url, e);
        } finally {
            // 关闭资源
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                log.error("关闭HTTP连接异常", e);
            }
        }

        return result;
    }

    /**
     * 发送POST请求（表单格式）
     * @param url 请求地址
     * @param paramMap 请求参数
     * @return 响应内容
     * @throws IOException IO异常
     */
    public static String doPost(String url, Map<String, String> paramMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";

        try {
            // 创建POST请求
            HttpPost httpPost = new HttpPost(url);

            // 构建表单参数
            if (paramMap != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> param : paramMap.entrySet()) {
                    paramList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            }

            httpPost.setConfig(builderRequestConfig());

            // 执行请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error("发送POST请求失败, url:{}", url, e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("关闭HTTP响应异常", e);
            }
        }

        return resultString;
    }

    /**
     * 发送POST请求（JSON格式）
     * @param url 请求地址
     * @param paramMap 请求参数（Map格式，会转换为JSON）
     * @return 响应内容
     * @throws IOException IO异常
     */
    public static String doPost4Json(String url, Map<String, String> paramMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";

        try {
            // 创建POST请求
            HttpPost httpPost = new HttpPost(url);

            if (paramMap != null) {
                // 构建JSON格式数据
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, String> param : paramMap.entrySet()) {
                    jsonObject.put(param.getKey(), param.getValue());
                }

                StringEntity entity = new StringEntity(jsonObject.toString(), "UTF-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }

            httpPost.setConfig(builderRequestConfig());

            // 执行请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error("发送POST JSON请求失败, url:{}", url, e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("关闭HTTP响应异常", e);
            }
        }

        return resultString;
    }

    /**
     * 发送POST请求（JSON字符串）
     * @param url 请求地址
     * @param param JSON字符串
     * @return 响应内容
     * @throws IOException IO异常
     */
    public static String doPostJson(String url, String param) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";

        try {
            // 创建POST请求
            HttpPost httpPost = new HttpPost(url);

            if (param != null && !param.isEmpty()) {
                StringEntity entity = new StringEntity(param, "UTF-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }

            httpPost.setConfig(builderRequestConfig());

            // 执行请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error("发送JSON请求失败, url:{}", url, e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("关闭HTTP响应异常", e);
            }
        }
        return resultString;
    }

    /**
     * 构建请求配置
     * @return RequestConfig对象
     */
    private static RequestConfig builderRequestConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(TIMEOUT_MSEC)
                .setConnectionRequestTimeout(TIMEOUT_MSEC)
                .setSocketTimeout(TIMEOUT_MSEC)
                .build();
    }
}
