package com.thinkinginjava.type_information.exercise.chapter14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description: page 340
 * 练习22：修改SimpleDynamicProxy.java。使其可以度量方法调用的次数。
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    private static Map<String,Integer> countMap = new ConcurrentHashMap<>();
    public DynamicProxyHandler(Object proxied) { this.proxied = proxied; }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("**** proxy: %s, method: %s, args: %s", proxy.getClass().getSimpleName(), method, args));
        if (args != null)
            for (Object arg : args)
                System.out.println("    " + arg);
        String methodName = method.getName();
        Integer count = countMap.get(methodName);
        if (count == null)
            countMap.put(methodName, 1);
        else {
            count++;
            countMap.put(methodName,count);
        }
        Object invoke = method.invoke(proxied, args);
        System.out.println(String.format("methodName:[%s], count:[%s]", methodName, countMap.get(methodName)));
        return invoke;
    }
}

public class Ex22 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        System.out.println();

        Interface proxy1 = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy1);
        System.out.println();

        Interface proxy2 = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
       // consumer(proxy2);
        proxy2.doSomething();
        System.out.println();
    }
}
/**output:
 * RealObject doSomething
 * RealObject somethingElse bonobo
 *
 * **** proxy: class com.thinkinginjava.type_information.exercise.chapter14_7.$Proxy0, method: public abstract void com.thinkinginjava.type_information.exercise.chapter14_7.Interface.doSomething(), args: null
 * RealObject doSomething
 * methodName:[doSomething], count:[1]
 * **** proxy: class com.thinkinginjava.type_information.exercise.chapter14_7.$Proxy0, method: public abstract void com.thinkinginjava.type_information.exercise.chapter14_7.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@6f94fa3e
 *     bonobo
 * RealObject somethingElse bonobo
 * methodName:[somethingElse], count:[1]
 *
 * **** proxy: class com.thinkinginjava.type_information.exercise.chapter14_7.$Proxy0, method: public abstract void com.thinkinginjava.type_information.exercise.chapter14_7.Interface.doSomething(), args: null
 * RealObject doSomething
 * methodName:[doSomething], count:[2]
 */