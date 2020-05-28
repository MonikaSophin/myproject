package com.dubbo.provider;
import com.google.common.collect.Lists;

import com.dubbo.common.ProtocolFactory;
import com.dubbo.common.model.URL;
import com.dubbo.common.service.ServiceConfig;
import com.dubbo.provider.impl.TestServiceImpl;
import com.dubbo.registry.impl.RemoteRegistry;
import com.dubbo.service.TestService;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class Provider {

    public static void main(String[] args) {

        //  1. 注册服务并暴露服务
        //  2. 启动tomcat

        //这里可以做成多注册中心, 可配置的
        URL url = new URL("http", "localhost", 8080, TestService.class.getSimpleName());
        ServiceConfig<TestService> config = new ServiceConfig<>();
        config.setUrls(Lists.newArrayList(url));
        config.setInterfaceClass(TestService.class);
        config.setRefObject(new TestServiceImpl());

        RemoteRegistry.put(config);

        ProtocolFactory.getProtocol(url).start(url);
    }
}
