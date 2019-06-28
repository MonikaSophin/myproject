package com.design_mode.structural_patterns.proxy_pattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤2.
 * cglib动态代理
 */
public class CglibProxy implements MethodInterceptor {

    //被代理类
    private  Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    /**
     * 重写方法拦截在方法前和方法后加入业务
     * @param o  o为目标对象
     * @param method method为目标方法
     * @param objects objects为参数，
     * @param methodProxy CGlib方法代理对象
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = method.invoke(target, objects);
        System.out.println("Cglib动态代理--operation");
        return result;
    }

    public static Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        //设置 需要被代理的目标对象
        enhancer.setSuperclass(target.getClass());
        //设置代理人
        enhancer.setCallback(new CglibProxy(target));
        return enhancer.create();
    }
}
