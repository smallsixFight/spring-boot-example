package com.lamlake.example.controller;

import com.lamlake.example.dto.Result;
import com.lamlake.example.dto.ResultGenerator;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result<?> UnauthorizedExceptionHandler (Exception ex) {
        System.out.println("统一异常处理...");
        System.out.println("权限不足");
        return ResultGenerator.genUnauthorizedResult();
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> ExceptionHandler (Exception ex) {
        System.out.println("统一异常处理...");
        System.out.println(ex.getMessage());
        return ResultGenerator.getFailResult(ex.getMessage());
    }
}
