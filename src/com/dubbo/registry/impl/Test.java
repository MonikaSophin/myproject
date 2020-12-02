package com.dubbo.registry.impl;

/**
 * 2020/5/29 9:31
 *
 * @author Sakata Gintoki
 * @version 1.0
 */
@FilterTest.Filter("xx")
public class Test {

    public static void main(String[] args) {
        FilterTest.Filter annotation = Test.class.getAnnotation(FilterTest.Filter.class);
        System.out.println(annotation.value());
    }
}
