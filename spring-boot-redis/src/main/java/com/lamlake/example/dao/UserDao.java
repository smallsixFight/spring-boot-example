package com.lamlake.example.dao;

import com.lamlake.example.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    public User getUser(int id) {
        System.out.println("如果没有走到这里，就说明缓存成功了");
        User user = new User(id, "test", "testRemark");
        return user;
    }

}
