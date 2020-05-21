package com.monika.proxy.static_pxoxy;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:13
 * @Version 1.0
 * @Description
 */
public class Test1 {

    public static void main(String[] args) {
        Target target = new TargetProxy();
        target.doSomething();
    }

}

