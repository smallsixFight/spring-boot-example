package com.lamlake.example.entity;

import lombok.Data;

@Data
public class Resource {

    private Integer id;
    private Integer parentId;
    private String name;
    private String url;
    private Integer type;
    private Integer status;
    private String operations;

}
