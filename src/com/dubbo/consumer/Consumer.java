package com.dubbo.consumer;

import com.dubbo.common.ProtocolModel;
import com.dubbo.common.ProxyFactory;
import com.dubbo.service.TestService;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class Consumer {

    public static void main(String[] args) {
        TestService testService = ProxyFactory.getProxy(TestService.class);
        testService.sayHello("xxx");
    }
}
