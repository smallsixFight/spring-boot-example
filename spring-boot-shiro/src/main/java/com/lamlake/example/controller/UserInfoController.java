package com.lamlake.example.controller;

import com.lamlake.example.dto.Result;
import com.lamlake.example.dto.ResultGenerator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @GetMapping("/userList")
    @RequiresPermissions("menu:view")
    public Result userInfo() {
        return ResultGenerator.getSuccessResult();
    }

    @GetMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd() {
        return "userInfoAdd";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userInfoDel() {
        return "userInfoDel";
    }
}
