package com.lamlake.example.service.impl;

import com.lamlake.example.dao.UserInfoDao;
import com.lamlake.example.entity.UserInfo;
import com.lamlake.example.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByAccount(String account) {
        System.out.println("UserInfoServiceImpl.findByAccount()");
        return userInfoDao.findByAccount(account);
    }

}
