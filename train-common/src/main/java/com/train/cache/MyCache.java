package com.train.cache;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义缓存组件
 * 用于存储微信公众号相关的全局凭据（accessToken和jsapiTicket）
 * 使用ReentrantLock保证线程安全
 */
@Component
public class MyCache {

    /** 微信公众号全局唯一接口调用凭据 */
    private volatile String accessToken;
    
    /** 微信公众号JSAPI票据 */
    private volatile String jsapiTicket;
    
    /** 线程锁，用于保证缓存操作的线程安全 */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 设置accessToken
     * @param accessToken 接口调用凭据
     */
    public void setAccessToken(String accessToken) {
        lock.lock();
        try {
            this.accessToken = accessToken;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取accessToken
     * @return 接口调用凭据
     */
    public String getAccessToken() {
        lock.lock();
        try {
            return accessToken;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取jsapiTicket
     * @return JSAPI票据
     */
    public String getJsapiTicket() {
        lock.lock();
        try {
            return jsapiTicket;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 设置jsapiTicket
     * @param jsapiTicket JSAPI票据
     */
    public void setJsapiTicket(String jsapiTicket) {
        lock.lock();
        try {
            this.jsapiTicket = jsapiTicket;
        } finally {
            lock.unlock();
        }
    }
}
