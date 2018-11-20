package com.lamlake.example.service.impl;

import com.lamlake.example.dao.SysRoleDao;
import com.lamlake.example.entity.SysRole;
import com.lamlake.example.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> getRolesByUserId(Integer id) {
        return sysRoleDao.getRolesByUserId(id);
    }
}
