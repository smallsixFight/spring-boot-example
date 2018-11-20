package com.lamlake.example.dto;

public enum ResultStateEnum {
    SUCCESS,
    FAIL,
    UNAUTHORIZED,//未认证（签名错误）
    NOT_FOUND,//接口不存在
    INTERNAL_SERVER_ERROR, //服务器内部错误
    NOT_LOGIN
}
