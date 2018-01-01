package com.sbtdubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Richard on 2017/10/25 0025.
 */
@SpringBootApplication
@MapperScan("com.sbtdubbo.api.mapper")
@ComponentScan(basePackages = "com.sbtdubbo",value = "com.sbtdubbo")
public class LauncherProvider {

    private static final Logger logger = LoggerFactory.getLogger(LauncherProvider.class);

    static {
        System.setProperty("dubbo.application.logger","slf4j");
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(LauncherProvider.class,args);
        }catch (Exception e){
            e.printStackTrace();
        }

//        System.setProperty("log.root", Constant.LOG_ROOT_DAILY);
//
//        System.setProperty("log.base", Constant.LOG_PATH_DAILY);
//
//        final String[] temp = args;
//
//        logger.info("oops: main入口函数编码-" + System.getProperty("file.encoding"));
//
//        if (Constant.LOG_MODE == 0) {
//            SpringApplication.run(LauncherProvider.class, args);
//            logger.info("oops: 线下开发测试");
//        } else {
//            logger.info("oops:" + args[0]);
//        }
//
//        if (ArrayUtils.isNotEmpty(args)) {
//            // 如果你的应用程序，运行后不自动退出，那么处理start时不要执行正常的代码，否则在部署测试 appctl.sh 的时候，会一直等待进程退出
//            if (args[0].equals("startup")) {
//                new Thread(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                System.out.println("启动Mythread子线程");
//                                logger.info("启动Mythread子线程");
//                                SpringApplication.run(LauncherProvider.class, temp);
//                            }
//                        }).start();
//
//                System.out.println("program startup");
//                logger.info("program startup");
//            } else if (args[0].equals("stop")) {
//                System.out.println("program stop");
//                logger.info("program stop");
//            } else if (args[0].equals("restart")) {
//                System.out.println("program restart");
//                logger.info("program restart");
//            } else if (args[0].equals("status")) {
//                System.out.println("program status");
//                logger.info("program status");
//            }
//        }
    }

    public void initLog4j(String[] args) {

    }
}
