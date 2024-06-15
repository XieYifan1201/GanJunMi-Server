package com.train.handler;

import com.train.constant.MessageConstant;
import com.train.exception.BaseException;
import com.train.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        //Duplicate entry 'zhangsan' for key 'idx_username'     重复username处理
        String msg = ex.getMessage();
        if (msg.contains("Duplicate entry")){
            String[] s = msg.split(" ");
            String username = s[2];
            return Result.error(username + "已存在");
        }else {
            return  Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }

}
