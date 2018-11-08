package com.lamlake.example.controller;

import com.lamlake.example.dao.UserDao;
import com.lamlake.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getUser")
    @Cacheable("userCache")
    public User getUser() {
        System.out.println("如果第二次没有走到这里说明缓存被添加了");
        return userDao.getUser(1);
    }

    @RequestMapping("/delUserCache")
    @CacheEvict(value = "userCache", allEntries = true)
    public String deleteUserCache() {
        return "SUCCESS";
    }

}
