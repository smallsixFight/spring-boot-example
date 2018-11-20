package com.lamlake.example.dao;

import com.lamlake.example.entity.SysRole;

import java.util.List;

public interface SysRoleDao {
    List<SysRole> getRolesByUserId(Integer id);
}
