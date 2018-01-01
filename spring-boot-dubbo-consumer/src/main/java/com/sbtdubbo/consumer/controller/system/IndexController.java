package com.sbtdubbo.consumer.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Richard on 2017/11/21 0021.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String goIndex(HttpServletRequest request, HttpServletResponse response){
        System.out.println("go index!");
        return "index";
    }

    /*@RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "system/login";
    }*/
}
