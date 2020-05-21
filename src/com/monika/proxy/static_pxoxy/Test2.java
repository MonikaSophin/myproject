package com.monika.proxy.static_pxoxy;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:27
 * @Version 1.0
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Service serviceProxy = new ServiceProxy(service);
        serviceProxy.doSomething();
    }

}
