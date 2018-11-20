package com.lamlake.example.service;

import com.lamlake.example.entity.UserInfo;

public interface IUserInfoService {
    UserInfo findByAccount(String account);
}
