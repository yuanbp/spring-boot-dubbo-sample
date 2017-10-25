package com.sbtdubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sbtdubbo.consumer.controller.CityController;

/**
 * Created by Richard on 2017/10/25 0025.
 */
@SpringBootApplication
public class LauncherConsumer {

    public static void main(String[] args) {
        ConfigurableApplicationContext config = SpringApplication.run(LauncherConsumer.class,args);
        CityController cityController = (CityController)config.getBean("cityController");
        try {
            cityController.getCity("710000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
