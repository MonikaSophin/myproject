package com.monika.proxy.dynamic;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:16
 * @Version 1.0
 * @Description
 */
public class ServiceImpl implements Service {

    @Override
    public void doSomething() {
        System.out.println("execute a service，eg: 饭店送达外卖");
    }
}
