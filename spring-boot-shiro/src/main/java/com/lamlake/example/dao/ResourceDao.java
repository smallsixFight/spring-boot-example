package com.lamlake.example.dao;

import com.lamlake.example.entity.Resource;

import java.util.List;

public interface ResourceDao {
    List<Resource> getResourcesByRoleId(Integer id);
}
