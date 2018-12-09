package com.thinkinginjava.inner_classes.example.chapter10_6.ex10_6_1;

/**
 * @Author: monika
 * @Date: 2018/12/7 22:42
 * @Version: 1.0
 * @Description: 对interface/Factories.java用匿名内部类进行重构
 */
interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Implementation1 implements Service{
    private Implementation1(){}
    @Override
    public void method1() { System.out.println("Implementation1#method1()"); }
    @Override
    public void method2() { System.out.println("Implementation1#method2()"); }
    public static ServiceFactory factory =
            () -> new Implementation1();
}

class Implementation2 implements Service{
    private Implementation2(){}
    @Override
    public void method1() { System.out.println("Implementation2#method1()"); }
    @Override
    public void method2() { System.out.println("Implementation2#method2()"); }
    public static ServiceFactory factory =
            () -> { Service service = new Implementation2();
                 return service; };
}

public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}
/**输出：
 * Implementation1#method1()
 * Implementation1#method2()
 * Implementation2#method1()
 * Implementation2#method2()
 */