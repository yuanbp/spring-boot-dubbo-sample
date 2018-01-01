package com.sbtdubbo.consumer.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sbtdubbo.api.interfaces.system.SecUserService;
import com.sbtdubbo.api.interfaces.UserService;
import com.sbtdubbo.api.model.SecUser;
import com.sbtdubbo.api.utils.Constant;

/**
 * Created by Richard on 2017/11/24 0024.
 */
@Controller
public class LoginController {

    @Reference
    private SecUserService secUserService;

    @Reference
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("user", null);
        return "system/login";
    }

    @RequestMapping("/loginUser")
    public String loginUser(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            SecUser user = (SecUser) subject.getPrincipal();
            session.setAttribute("user", user);
            return "system/index";
        } catch (Exception e) {
            e.printStackTrace();
            SecUser user = new SecUser();
            user.setUserName(username);
            user.setPassword(password);
            request.setAttribute("user", user);
            request.setAttribute("loginstatus", Constant.LOGINERR);
            System.err.println("----------认证失败，退回登陆----------");
            return "system/login";//返回登录页面
        }

    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "system/login";
    }
}
