//package com.sbtdubbo.provider.dbconfig;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.io.VFS;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
///**
// * Created by Richard on 2017/11/21 0021.
// */
//@Configuration
//@EnableTransactionManagement
////@MapperScan("com.xxx.xxx.mybatis.mapper")
////@MapperScan("/mapper/*.xml")
//public class SessionFactoryConfig implements TransactionManagementConfigurer {
//
//    private static Logger log = LoggerFactory.getLogger(SessionFactoryConfig.class);
//
//    /**
//     * mybatis 配置路径
//     */
//    //private static String MYBATIS_CONFIG = "mybatis-config.xml";
//    private static String MYBATIS_CONFIG = "/mybatis/mybatis-config.xml";
//    //@Value("${mybatis.config-location}")
//    //private String MYBATIS_CONFIG;
//
//    @Autowired
//    private DataSource dataSource;
//
//    //private String typeAliasPackage = "com.xxx.xxx.mybati.model";
//    //private String typeAliasPackage = "com.sbtdubbo.api.model";
//    @Value("${mybatis.type-aliases-package}")
//    private String typeAliasPackage;
//
//    //private String mapperLocations = "classpath*:/mapper/*.xml";
//    @Value("${mybatis.mapper-locations}")
//    private String mapperLocations;
//
//    /**
//     * 创建sqlSessionFactoryBean 实例
//     * 并且设置configtion 如驼峰命名.等等
//     * 设置mapper 映射路径
//     * 设置datasource数据源
//     *
//     * @return
//     * @throws Exception
//     */
////    @Bean(name = "sqlSessionFactory")
////    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
////        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
////        /** 设置mybatis configuration 扫描路径 */
////        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
////        /** 设置datasource */
////        sqlSessionFactoryBean.setDataSource(dataSource);
////        /** 设置typeAlias 包扫描路径 */
////        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
////        return sqlSessionFactoryBean;
////    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//
//        log.info("*************************sqlSessionFactory:begin***********************");
//
//        VFS.addImplClass(SpringBootVFS.class);
//
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setTypeAliasesPackage(typeAliasPackage);
//        //sessionFactory.setTypeHandlersPackage(properties.typeHandlerPackage);
//
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sessionFactory.setMapperLocations(resolver.getResources(mapperLocations));
//
////      sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(properties.configLocation));
//
//        SqlSessionFactory resultSessionFactory = sessionFactory.getObject();
//
//        log.info("===typealias==>" + resultSessionFactory.getConfiguration().getTypeAliasRegistry().getTypeAliases());
//
//        log.info("*************************sqlSessionFactory:successs:" + resultSessionFactory + "***********************");
//
//        return resultSessionFactory;
//
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}