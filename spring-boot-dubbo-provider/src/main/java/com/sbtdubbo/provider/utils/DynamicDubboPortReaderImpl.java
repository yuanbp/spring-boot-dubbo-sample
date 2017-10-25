package com.sbtdubbo.provider.utils;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.config.ProtocolConfig;

/**
 * Created by Richard on 2017/09/21 0021.
 */
@Component
public class DynamicDubboPortReaderImpl implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;
    private int port = 20880;

    @PostConstruct
    public void init() {
        Map<String, ProtocolConfig> beansOfType = applicationContext.getBeansOfType(ProtocolConfig.class);
        for (Map.Entry<String, ProtocolConfig> item : beansOfType.entrySet()) {
            port = NetUtils.getAvailablePort();
            System.out.println("##################use sure###########################"+port);
            item.getValue().setPort(port);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }
}
