package com.train.service.Impl;

import com.train.mapper.CommonMapper;
import com.train.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {


    @Autowired
    private CommonMapper commonMapper;

    /**
     * 更新空表路径
     * @param p
     */
    @Override
    public void save(String p) {
        commonMapper.save(p);
    }

    /**
     * 获取空表路径
     * @return
     */
    @Override
    public String get() {
        return commonMapper.get();
    }


}
