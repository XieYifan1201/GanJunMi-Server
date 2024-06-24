package com.train.cache;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义缓存类
 */
@Component
public class MyCache {

    //公众号的全局唯一接口调用凭据
    private String accessToken;
    private String jsapiTicket;
    private final ReentrantLock lock = new ReentrantLock();

    public void setAccessToken(String accessToken) {
        lock.lock();
        try {
            this.accessToken = accessToken;
        }finally {
            lock.unlock();
        }

    }

    public String getAccessToken() {
        lock.lock();
        try {
            return accessToken;
        }finally {
            lock.unlock();
        }
    }

    public String getJsapiTicket() {
        lock.lock();
        try {
            return jsapiTicket;
        }finally {
            lock.unlock();
        }
    }

    public void setJsapiTicket(String jsapiTicket) {
        lock.lock();
        try {
            this.jsapiTicket = jsapiTicket;
        }finally {
            lock.unlock();
        }
    }
}
