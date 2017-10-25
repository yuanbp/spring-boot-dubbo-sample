package com.sbtdubbo.provider.service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.dubbo.config.annotation.Service;
import com.sbtdubbo.api.domain.CityInfo;
import com.sbtdubbo.api.interfaces.CityService;

/**
 * Created by Richard on 2017/10/25 0025.
 */
@Service
public class CityServiceImpl implements CityService {

    @Override
    public CityInfo findCityByZipCode(String zipCode) throws Exception {
        URL url = new URL("http://opendata.baidu.com/post/s?wd="+zipCode);
        URLConnection hul = url.openConnection();
        InputStream is = hul.getInputStream();
        byte[] by = new byte[1024];
        int len = 0;
        String address = null;
        while((len=is.read(by))!=-1){
            address += new String(by,0,len,"GBK");
        }
        try {
            System.out.println(address.substring(address.indexOf("</em>：")+6,address.indexOf("</h3>")));
            return new CityInfo(zipCode,address.substring(address.indexOf("</em>：")+6,address.indexOf("</h3>")));
        } catch (Exception e) {
            System.out.println("起您输入误");
        }
        return null;
    }

}
