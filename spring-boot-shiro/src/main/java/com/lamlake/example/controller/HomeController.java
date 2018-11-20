package com.lamlake.example.controller;

import com.lamlake.example.dto.Result;
import com.lamlake.example.dto.ResultGenerator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
    public String login (HttpServletRequest request, Map<String, Object> map) {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String account = request.getParameter("account");
        System.out.println("account==>" + account);
        System.out.println("exception=" + exception);
        String msg = "no msg";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        return "/login";

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

    @PostMapping("/doLogin")
    public Object loginController(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            e.printStackTrace();
            return "登录失败";
        }
        return "登录成功";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}
