package com.sbtdubbo.consumer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sbtdubbo.api.interfaces.UserService;
import com.sbtdubbo.api.model.User;
import com.sbtdubbo.api.utils.HttpUtil;

/**
 * Created by Richard on 2017/11/23 0023.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("index")
    public String index(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("user",null);
        return "user/user";
    }

    @RequestMapping("/selectbyprimarykey")
    public String selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response,User user){
        try {
            ///Map map = HttpUtil.requestInfo(request);
            //Integer id = Integer.parseInt(map.get("id").toString());
            List<User> users = userService.selectBySelective(user);
            if(users == null || users.size()<=0){
                HttpUtil.responseWrite(response,"用户不存在");
                return "user/user";
            }
            request.setAttribute("returnuser",users.get(0));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "user/userinfo";
    }
}
