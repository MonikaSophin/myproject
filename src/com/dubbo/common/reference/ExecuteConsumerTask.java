package com.dubbo.common.reference;

import com.dubbo.common.LoadBalance;
import com.dubbo.common.ProtocolFactory;
import com.dubbo.common.model.Invocation;
import com.dubbo.common.model.URL;
import com.dubbo.protocol.Protocol;
import com.dubbo.registry.impl.RemoteRegistry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author XueYing.Cao
 * @date 2020/5/28
 */
public class ExecuteConsumerTask {

    public static <T> T execute(ReferenceConfig referenceConfig) {
        Class interfaceClass = referenceConfig.getInterfaceClass();
        URL url = referenceConfig.getUrl();

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {
            String mock = System.getProperty("mock");
            if (mock != null && mock.startsWith("return:")) {
                String result = mock.replace("return:", "");
                return result;
            }

            Invocation invocation = new Invocation(interfaceClass.getName(), new String[]{method.getName()}, method.getParameterTypes(), args);
            List<URL> urlList = RemoteRegistry.getURL(interfaceClass.getName(), url);
            URL u = LoadBalance.random(urlList);
            Protocol protocol = ProtocolFactory.getProtocol(u);
            String result = protocol.send(u, invocation);
            return result;
        });
    }

}
