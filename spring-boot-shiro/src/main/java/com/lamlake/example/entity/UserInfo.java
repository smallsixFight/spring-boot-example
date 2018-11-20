package com.lamlake.example.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UserInfo {

    private Integer id;
    private String account;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Integer isAdmin;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String remark;

}
