package com.design_mode.structural_patterns.proxy_pattern;

import com.design_mode.structural_patterns.proxy_pattern.model.Shopping;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤3.
 * JDK动态代理，要将目标对象传入
 */
public class JdkProxy implements InvocationHandler {

    private Shopping realObject;

    public JdkProxy(Shopping realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("shopping".equalsIgnoreCase(method.getName())) {
            Object result = method.invoke(realObject, args);
            System.out.println("JDK动态代理--shopping");
            return result;
        }
        return null;
    }
}
