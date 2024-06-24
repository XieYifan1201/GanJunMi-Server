package com.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling       //开启任务调度
@EnableCaching          //开启缓存注解
@EnableTransactionManagement    //开启注解方式的事务管理
public class TrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainApplication.class, args);
    }

}
