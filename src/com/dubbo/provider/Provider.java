package com.dubbo.provider;

import com.dubbo.common.ProtocolFactory;
import com.dubbo.common.ProtocolModel;
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
        //  2. 本地注册服务,相当于交给spring去管理
        //  3. 启动tomcat

        //这里可以做成多注册中心, 可配置的
        ProtocolModel protocolModel = new ProtocolModel();
        protocolModel.setProtocol("http");
        protocolModel.setIp("localhost");
        protocolModel.setPort("8080");
        protocolModel.setServiceName(TestService.class.getName());
        protocolModel.setMethodNames(new String[]{"sayHello"});
        RemoteRegistry.put(protocolModel);

        LocalRegister.regist(TestService.class.getName(), TestServiceImpl.class);

        ProtocolFactory.getProtocol(protocolModel).start(protocolModel);
    }
}
