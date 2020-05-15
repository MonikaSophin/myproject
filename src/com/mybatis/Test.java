package com.mybatis;

import com.mybatis.mapper_scan.self.MyAppConfig;
import com.mybatis.mapper_scan.spring.AppConfig;
import com.mybatis.mapper_scan.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XueYing.Cao
 * @date 2020/5/14
 */

public class Test {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
        TestService testService = ac.getBean(TestService.class);
        System.out.println(testService.getUsers());
    }
}
