package com.lamlake.example.service;

import com.lamlake.example.entity.SysRole;

import java.util.List;

public interface ISysRoleService {
    List<SysRole> getRolesByUserId(Integer id);
}
