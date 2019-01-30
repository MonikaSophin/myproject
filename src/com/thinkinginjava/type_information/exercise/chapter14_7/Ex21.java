package com.thinkinginjava.type_information.exercise.chapter14_7;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description: page 340
 * 练习21：修改SimpleProxyDemo.java，使其可以度量方法调用的次数。
 */
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() { System.out.println("RealObject doSomething"); }
    @Override
    public void somethingElse(String arg) { System.out.println("RealObject somethingElse " + arg); }
}

class SimpleProxy implements Interface {
    private static int doCount;
    private static int seCount2;
    private Interface proxied;
    public SimpleProxy(Interface proxied) { this.proxied = proxied; }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        doCount++;
        System.out.println("doCount = " + doCount);
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        seCount2++;
        System.out.println("seCount2 = " + seCount2);
    }
}

public class Ex21 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
        System.out.println();
    }
}
/**output:
 * RealObject doSomething
 * RealObject somethingElse bonobo
 *
 * SimpleProxy doSomething
 * RealObject doSomething
 * doCount = 1
 * SimpleProxy somethingElse bonobo
 * RealObject somethingElse bonobo
 * seCount2 = 1
 *
 * SimpleProxy doSomething
 * RealObject doSomething
 * doCount = 2
 * SimpleProxy somethingElse bonobo
 * RealObject somethingElse bonobo
 * seCount2 = 2
 */