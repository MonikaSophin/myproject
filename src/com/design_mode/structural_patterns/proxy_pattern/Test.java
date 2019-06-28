package com.design_mode.structural_patterns.proxy_pattern;

import com.design_mode.structural_patterns.proxy_pattern.model.Me;
import com.design_mode.structural_patterns.proxy_pattern.model.MeCglib;
import com.design_mode.structural_patterns.proxy_pattern.model.Shopping;

import java.lang.reflect.Proxy;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        //静态代理(代理类必须要有接口)
        Shopping staticProxy = new StaticProxy();
        staticProxy.shopping();
        System.out.println();

        //2.jdk动态代理(代理类必须要有接口)
        JdkProxy jdkProxy = new JdkProxy(new Me());
        Shopping jdk_proxy = (Shopping) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[]{ Shopping.class }, jdkProxy);
        jdk_proxy.shopping();
        System.out.println();

        //3.cglib动态代理(完全不受代理类必须实现接口的限制)
        MeCglib cglib_proxy = (MeCglib) CglibProxy.getProxy(new MeCglib());
        cglib_proxy.shopping();
        cglib_proxy.working(); //final方法不会被代理
        //!cglib_proxy.playing();
    }
}
/**output:
 * 想买东西，不想出门，怎么办？
 * 静态代理--shopping
 *
 * 想买东西，不想出门，怎么办？
 * JDK动态代理--shopping
 *
 * 想买东西，但是不想动...
 * Cglib动态代理--operation
 * 我正在工作
 */