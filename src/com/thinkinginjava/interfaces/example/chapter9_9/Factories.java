package com.thinkinginjava.interfaces.example.chapter9_9;

/**
 * 1.生成遵循某个接口的对象的典型方式就是工厂方法。这与直接调用构造器不同，
 * 我们在工厂对象上调用的是创建方法，而该工厂对象将生成接口的某个实现的对象。
 * 2.为什么要添加这种额外级别的间接性：一个常见的原因是想要创建框架。
 * 3.更为优雅的工厂实现方式：就是使用匿名内部类。
 */
interface Service {
  void method1();
  void method2();
}

interface ServiceFactory {
  Service getService();
}

class Implementation1 implements Service {
  Implementation1() {} // Package access
  public void method1() { System.out.println("Implementation1 method1");}
  public void method2() { System.out.println("Implementation1 method2");}
}	

class Implementation1Factory implements ServiceFactory {
  public Service getService() {
    return new Implementation1();
  }
}

class Implementation2 implements Service {
  Implementation2() {} // Package access
  public void method1() { System.out.println("Implementation2 method1");}
  public void method2() { System.out.println("Implementation2 method2");}
}

class Implementation2Factory implements ServiceFactory {
  public Service getService() {
    return new Implementation2();
  }
}	

public class Factories {
  public static void serviceConsumer(ServiceFactory fact) {
    Service s = fact.getService();
    s.method1();
    s.method2();
  }
  public static void main(String[] args) {
    serviceConsumer(new Implementation1Factory());
    // 实现是完全可以互换的Games.java:
    serviceConsumer(new Implementation2Factory());
  }
}

/** Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
