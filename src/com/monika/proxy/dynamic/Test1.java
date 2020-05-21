package com.monika.proxy.dynamic;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/21 23:35
 * @Version 1.0
 * @Description
 */
public class Test1 {

    public static void main(String[] args) {

        Service service = new ServiceImpl();

        //在这里可以传递不同的Service子类，
        // 在不产生冗余的代理类的情况下，实现静态代理一样的效果。
        Object intance = new ServiceProxy(service).getIntance();
        Service proxy =  (Service)intance;
        proxy.doSomething();

    }
}
