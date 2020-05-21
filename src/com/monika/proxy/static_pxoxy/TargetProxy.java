package com.monika.proxy.static_pxoxy;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:08
 * @Version 1.0
 * @Description
 */
public class TargetProxy extends Target {

    @Override
    public void doSomething() {
        System.out.println("do proxy thing, eg: 骑手送外卖");
        //此处可以写，也可以不写,代理不一定要增强目标方法，但是不改变目标方法，代理模式似乎没有太大意义。
        super.doSomething();
    }
}
