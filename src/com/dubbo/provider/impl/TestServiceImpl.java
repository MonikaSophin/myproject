package com.dubbo.provider.impl;

import com.dubbo.service.TestService;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
