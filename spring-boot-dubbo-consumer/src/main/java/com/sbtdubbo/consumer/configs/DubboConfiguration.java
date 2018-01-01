package com.sbtdubbo.consumer.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import com.sbtdubbo.api.interfaces.system.SecUserService;
import com.sbtdubbo.consumer.author.ShiroConfiguration;

/**
 * Created by Richard on 2017/11/27 0027.
 */
@AutoConfigureBefore(ShiroConfiguration.class)
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
@Order(value = 1)
public class DubboConfiguration implements CommandLineRunner, EnvironmentAware {

    private RegistryConfig registryConfig; //保存配置对象避免重复创建
    private ApplicationConfig applicationConfig; //保存配置对象避免重复创建

    @Value("${dubbo.application.name}")
    private String applicationName;

    @Value("${dubbo.application.logger}")
    private String logger;

    @Value("${dubbo.registr.protocol}")
    private String protocol;

    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Value("${dubbo.protocol.name}")
    private String protocolName;

    @Value("${dubbo.protocol.port}")
    private int protocolPort;

    @Value("${dubbo.provider.timeout}")
    private int timeout;

    @Value("${dubbo.provider.retries}")
    private int retries;

    @Value("${dubbo.provider.delay}")
    private int delay;

    @Value("${dubbo.annotation.package}")
    private String packageName;

    /**
     * 设置dubbo扫描包
     *
     * @param packageName
     * @return
     */
    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }

    /**
     * 注入dubbo上下文
     *
     * @return
     */
//    @Bean
//    public ApplicationConfig applicationConfig() {
//        System.err.println("--------------Dubbo-Configuarion加载了！--------------");
//        // 当前应用配置
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName(this.applicationName);
//        return applicationConfig;
//    }

    /**
     * 注入dubbo注册中心配置,基于zookeeper
     *
     * @return
     */
//    @Bean
//    public RegistryConfig registryConfig() {
//        // 连接注册中心配置
//        RegistryConfig registry = new RegistryConfig();
//        registry.setProtocol(protocol);
//        registry.setAddress(registryAddress);
//        return registry;
//    }

    /**
     * 默认基于dubbo协议提供服务
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        protocolConfig.setThreads(200);
        System.out.println("默认protocolConfig：" + protocolConfig.hashCode());
        return protocolConfig;
    }

    /**
     * dubbo服务提供
     *
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
    @Bean(name = "defaultProvider")
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(timeout);
        providerConfig.setRetries(retries);
        providerConfig.setDelay(delay);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
    }

    @Override
    public void run(String... strings) throws Exception {
    }

    //利用EnvironmentAware避免赖汉式的性能问题，饿汉式又无法获取到配置的尴尬
    @Override
    public void setEnvironment(Environment env) {
        applicationConfig = new ApplicationConfig();
        applicationConfig.setName(this.applicationName);
        registryConfig = new RegistryConfig(env.getProperty(this.registryAddress));
        registryConfig.setProtocol(protocol);
    }

    private <T> T getReference(Class<T> c) { //通用获取代理对象方法
        ReferenceConfig<T> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(c);
        return reference.get();
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        return registryConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(this.packageName);
        return annotationBean;
    }

    @Bean
    public SecUserService secUserService() {
        return getReference(SecUserService.class);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public int getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(int protocolPort) {
        this.protocolPort = protocolPort;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public RegistryConfig getRegistryConfig() {
        return registryConfig;
    }

    public void setRegistryConfig(RegistryConfig registryConfig) {
        this.registryConfig = registryConfig;
    }

    public ApplicationConfig getApplicationConfig() {
        return applicationConfig;
    }

    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
