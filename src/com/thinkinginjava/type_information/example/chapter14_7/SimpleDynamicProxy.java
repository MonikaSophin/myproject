package com.thinkinginjava.type_information.example.chapter14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description:
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) { this.proxied = proxied; }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("**** proxy: %s, method: %s, args: %s", proxy.getClass(), method, args));
        if (args != null)
            for (Object arg : args)
                System.out.println("    " + arg);
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        System.out.println();

        Object o = Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        Interface proxy = (Interface)o;
        consumer(proxy);
    }
}
/**output(90% match):
 * RealObject doSomething
 * RealObject somethingElse bonobo
 *
 * **** proxy: class com.thinkinginjava.type_information.example.chapter14_7.$Proxy0, method: public abstract void com.thinkinginjava.type_information.example.chapter14_7.Interface.doSomething(), args: null
 * RealObject doSomething
 * **** proxy: class com.thinkinginjava.type_information.example.chapter14_7.$Proxy0, method: public abstract void com.thinkinginjava.type_information.example.chapter14_7.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@6f94fa3e
 *     bonobo
 * RealObject somethingElse bonobo
 */