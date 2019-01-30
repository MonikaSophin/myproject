package com.thinkinginjava.type_information.example.chapter14_7;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description:
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
    private Interface proxied;
    public SimpleProxy(Interface proxied) { this.proxied = proxied; }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println();

        consumer(new SimpleProxy(new RealObject()));
    }
}
/**output:
 * RealObject doSomething
 * RealObject somethingElse bonobo
 *
 * SimpleProxy doSomething
 * RealObject doSomething
 * SimpleProxy somethingElse bonobo
 * RealObject somethingElse bonobo
 */