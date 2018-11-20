package com.lamlake.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class Resource {

    private Integer id;
    private Integer parentId;
    private String name;
    private String url;
    private Integer type;
    private Integer status;
    private String operations;
    private List<SysRole> sysRoleList;

}