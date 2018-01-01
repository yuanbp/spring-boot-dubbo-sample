package com.sbtdubbo.api.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Richard on 2017/11/23 0023.
 */
public class HttpUtil {

    public static Map requestInfo(HttpServletRequest request){
        Map returnMap = new HashMap();
        System.out.println("getRequestURL:"+request.getRequestURL());
        System.out.println("getRequestURI:"+request.getRequestURI());
        System.out.println("getQueryString:"+request.getQueryString());
        System.out.println("getRemoteAddr:"+request.getRemoteAddr());
        System.out.println("getRemoteHost:"+request.getRemoteHost());
        System.out.println("getRemotePort:"+request.getRemotePort());
        System.out.println("getRemoteUser:"+request.getRemoteUser());
        System.out.println("getLocalAddr:"+request.getLocalAddr());
        System.out.println("getLocalName:"+request.getLocalName());
        System.out.println("getLocalPort:"+request.getLocalPort());
        System.out.println("getMethod:"+request.getMethod());
        System.out.println("-------request.getParamterMap()-------");
        // 得到请求的参数 Map，注意 map 的 value 是 String 数组类型
        Map map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String[] values = (String[]) map.get(key);
            for (String value : values) {
                returnMap.put(key,value);
                System.out.println(key+"="+value);
            }
        }
        System.out.println("--------request.getHeader()--------");
        // 得到请求头的 name 集合
        Enumeration<String> em = request.getHeaderNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"="+value);
        }

        return returnMap;
    }

    public static void responseWrite(HttpServletResponse response,String message) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script th:inline=\"javascript\">alert('"+message+"！')</script>");
    }
}
