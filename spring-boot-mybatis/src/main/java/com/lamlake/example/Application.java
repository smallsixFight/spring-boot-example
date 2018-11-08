package com.lamlake.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lamlake.example.mapper")
public class Application {
    public static void main(String[] args) {

    }
}
