package com.sbtdubbo.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sbtdubbo.api.domain.CityInfo;
import com.sbtdubbo.api.interfaces.CityService;

/**
 * Created by Richard on 2017/10/25 0025.
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Reference
    CityService cityService;

    public void getCity(String zipCode) throws Exception {
        CityInfo cityInfo = cityService.findCityByZipCode(zipCode);
        System.out.println("邮编："+cityInfo.getZipCode()+"    城市："+cityInfo.getCityName());
    }
}
