package com.lamlake.example.dao;

import com.lamlake.example.entity.UserInfo;

public interface UserInfoDao {
    UserInfo findByAccount(String account);

}
