package com.sbtdubbo.consumer.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Richard on 2017/10/26 0026.
 */
@Configuration
//@EnableWebMvc  启用这个注解会完全屏蔽掉spring boot 的springmvc配置，如果只是需要自定义部分内容，启用configuration就好
public class WebMVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/hello").setViewName("/hello");
    }
}
