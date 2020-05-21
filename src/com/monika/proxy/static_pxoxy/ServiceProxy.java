package com.monika.proxy.static_pxoxy;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:17
 * @Version 1.0
 * @Description
 */

/**
 * 代理对象与目标对象都要实现同一接口，我的理解是
 * 既然是代理模式，肯定是需要目标来委托代理的。
 * 那就要目标与代理之间约定好需要代理什么东西。（这里指的是方法内容）
 * 而接口就是一种目标与代理之间很好地一种约定。
 */
public class ServiceProxy implements Service {

    private Service service;

    //这里也可以提供set方法，也可以两者都提供，与spring的两种注入方式很类似。
    // spring的构造注入与setter注入
    public ServiceProxy(Service service) {
        this.service = service;
    }

    @Override
    public void doSomething() {
        System.out.println("execute proxy service，eg：骑手送外卖");
        service.doSomething();
    }
}
