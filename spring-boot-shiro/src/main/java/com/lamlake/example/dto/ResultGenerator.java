package com.lamlake.example.dto;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result getSuccessResult() {
        return new Result(0, ResultStateEnum.SUCCESS, DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result getSuccessResult(T data) {
        return new Result(0, ResultStateEnum.SUCCESS, data, DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result getFailResult(String message) {
        return new Result(-1, ResultStateEnum.FAIL, message);
    }

    public static Result genUnauthorizedResult() {
        return new Result(1, ResultStateEnum.UNAUTHORIZED, "无该资源的操作权限！");
    }

    public static Result genNotFoundResult() {
        return new Result(1, ResultStateEnum.NOT_FOUND, "目标资源不存在！");
    }

    public static Result genServerErrorResult() {
        return new Result(-1, ResultStateEnum.INTERNAL_SERVER_ERROR, "内部服务器错误！");
    }

}
