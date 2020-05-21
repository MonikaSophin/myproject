package com.monika.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:29
 * @Version 1.0
 * @Description
 */
public class ServiceProxy {

    private Service service;

    public ServiceProxy(Service service) {
        this.service = service;
    }

    public Object getIntance() {
        /**
         * {@link Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)}
         * ClassLoader: 使用jvm类加载机制加载代理类
         * Class[]: 代理类需要实现的接口
         * InvocationHandler: 对目标方法进行代理
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Service.class},
                (proxy, method, args) -> {
            System.out.println("execute proxy service，eg：骑手送外卖");
            Object invoke = method.invoke(service, args);
//            System.out.println(invoke.toString());
//            System.out.println(invoke.hashCode());
//            System.out.println(proxy.toString());
//            System.out.println(proxy.hashCode());
            // 上面注释的toString()与hashCode()会报错，故这里比较地址值应该是false，
            // 我猜想代理对象是没有生成toString()与hashCode()，这点猜想待证实
            System.out.println(proxy == invoke);
            return invoke;
//            return proxy; //这里返回proxy也是同样的效果
        });
    }

}
