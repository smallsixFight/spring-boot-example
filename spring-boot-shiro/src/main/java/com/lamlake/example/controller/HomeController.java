package com.lamlake.example.controller;

import com.lamlake.example.dto.Result;
import com.lamlake.example.dto.ResultGenerator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class HomeController {
    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public Result login (HttpServletRequest request, Map<String, Object> map) {
        return ResultGenerator.getNotLogin("未登录");

    }

    @PostMapping("/loggingTest")
    public Result<?> logging (HttpServletRequest request) {
        System.out.println("loggingTest...");
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("account"), request.getParameter("password"));
        Subject user = SecurityUtils.getSubject();
        try {
            user.login(token);
        } catch (Exception e) {
            System.out.println("异常");
            return ResultGenerator.getFailResult("验证失败");
        }
        System.out.println("Return-->" + ResultGenerator.getSuccessResult());
        return ResultGenerator.getSuccessResult();
    }

    @GetMapping("/logout")
    public Result logout () {
        Subject user = SecurityUtils.getSubject();
        user.logout();
        return ResultGenerator.getSuccessResult();
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}
