package com.lamlake.example.dto;

import lombok.Data;

@Data
public class Result<T> {

    public Result(int code, ResultStateEnum state, String message) {
        this.code = code;
        this.state = state;
        this.message = message;
    }

    public Result(int code, ResultStateEnum state, T data, String message) {
        this.code = code;
        this.state = state;
        this.data = data;
        this.message = message;
    }

    private int code;
    private ResultStateEnum state;
    private String message;
    private T data;
}
