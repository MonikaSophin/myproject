package com.monika.test.domain;

/**
 * @author: XueYing.Cao
 * @date: 2018/11/16
 * @description:
 */
public class SpiService2 implements SpiService {
    @Override
    public String sayHi(String name) {
        return "你好 " + name;
    }
}
