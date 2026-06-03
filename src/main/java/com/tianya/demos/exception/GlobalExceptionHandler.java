package com.tianya.demos.exception;

import com.tianya.demos.pojo.entity.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器：统一捕获并处理所有Controller抛出的异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获所有异常，返回统一的错误响应
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    }

}
