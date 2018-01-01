package com.sbtdubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtdubbo.consumer.controller.CityController;

/**
 * Created by Richard on 2017/10/25 0025.
 */
//@RestController
@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sbtdubbo", value = "com.sbtdubbo")
public class LauncherConsumer {

    static {
        System.setProperty("dubbo.application.logger", "slf4j");
    }

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext config = SpringApplication.run(LauncherConsumer.class, args);
            CityController cityController = (CityController) config.getBean("cityController");

            //根据邮查询城市名并输出城市和邮编
            cityController.getCity("710000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}
