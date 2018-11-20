package com.lamlake.example.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class SysRole {

    private Integer id;
    private String roleName;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String remark;
}
