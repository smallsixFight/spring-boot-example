package com.lamlake.example.dao;

import com.lamlake.example.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testFindByAccount() {
        UserInfo userInfo = userInfoDao.findByAccount("admin");
        System.out.println(userInfo);
    }

}