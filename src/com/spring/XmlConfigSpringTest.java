package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XueYing.Cao
 * @date 2020/6/16
 */
public class XmlConfigSpringTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        System.out.println(ca.getBean("a"));
    }
}
