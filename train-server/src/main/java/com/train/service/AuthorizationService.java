package com.train.service;

import java.util.Map;

public interface AuthorizationService {

    /**
     * 获取jsapi_ticket签名
     * @return
     */
    Map<String, String> getTicketSig(String url);
}
