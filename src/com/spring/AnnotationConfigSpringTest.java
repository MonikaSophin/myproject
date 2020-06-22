package com.spring;

import com.spring.component.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XueYing.Cao
 * @date 2020/6/16
 */
public class AnnotationConfigSpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(ac.getBean("config"));
        System.out.println(ac.getBean("a"));
    }
}
