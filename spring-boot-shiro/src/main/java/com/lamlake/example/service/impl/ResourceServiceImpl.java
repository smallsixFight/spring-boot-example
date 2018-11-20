package com.lamlake.example.service.impl;

import com.lamlake.example.dao.ResourceDao;
import com.lamlake.example.entity.Resource;
import com.lamlake.example.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> getResourcesByRoleId(Integer id) {
        return resourceDao.getResourcesByRoleId(id);
    }
}
