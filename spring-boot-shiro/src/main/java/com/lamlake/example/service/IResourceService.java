package com.lamlake.example.service;

import com.lamlake.example.entity.Resource;

import java.util.List;

public interface IResourceService {
    List<Resource> getResourcesByRoleId(Integer id);
}
