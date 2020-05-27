package com.dubbo.provider.impl;

import com.dubbo.service.TestService;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class TestServiceImpl implements TestService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
