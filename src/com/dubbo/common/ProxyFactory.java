package com.dubbo.common;

import com.dubbo.protocol.Protocol;
import com.dubbo.registry.impl.RemoteRegistry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory<T> {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(final Class interfaceClass) {
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String mock = System.getProperty("mock");
                if (mock != null && mock.startsWith("return:")) {
                    String result = mock.replace("return:", "");
                    return result;
                }

                List<ProtocolModel> protocolModels = RemoteRegistry.get(interfaceClass.getName());

                ProtocolModel protocolModel = LoadBalance.random(protocolModels);
                Protocol protocol = ProtocolFactory.getProtocol(protocolModel);
                return protocol.send(protocolModel);
            }
        });
    }

}
