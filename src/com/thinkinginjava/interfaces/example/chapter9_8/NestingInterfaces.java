package com.thinkinginjava.interfaces.example.chapter9_8;

/**
 * 1.接口可以嵌套在类或其他接口中。
 * 2.特别要注意的是：当实现某个接口时，并不需要实现嵌套在其内部的任何接口。
 * 而且，private接口不能在定义它的类之外被实现。
 */
class A {
  interface B {
    void f();
  }
  public class BImp implements B {
    public void f() { System.out.println("xx"); }
  }
  private class BImp2 implements B {
    public void f() { System.out.println("yy"); }
  }
  public interface C {
    void f();
  }
  class CImp implements C {
    public void f() {}
  }	
  private class CImp2 implements C {
    public void f() {}
  }
  private interface D {
    void f();
  }
  private class DImp implements D {
    public void f() {}
  }
  public class DImp2 implements D {
    public void f() {}
  }
  public D getD() { return new DImp2(); }
  public B getB() { return new BImp2(); }
  public void getBf() { new BImp2().f(); }
  private D dRef;
  public void receiveD(D d) {
    dRef = d;
    dRef.f();
  }
}	

interface E {
  interface G {
    void f();
  }
  // Redundant "public":
  public interface H {
    void f();
  }
  void g();
  // Cannot be private within an interface:
  //! private interface I {}
}	

public class NestingInterfaces {
  public class BImp implements A.B {
    public void f() {}
  }
  class CImp implements A.C {
    public void f() {}
  }
  // Cannot implement a private interface except
  // within that interface's defining class:
  //! class DImp implements A.D {
  //!  public void f() {}
  //! }
  class EImp implements E {
    public void g() {}
  }
  class EGImp implements E.G {
    public void f() {}
  }
  class EImp2 implements E {
    public void g() {}
    class EG implements G {
      public void f() {}
    }
  }	
  public static void main(String[] args) {
    A a = new A();
    // Can't access A.D:
    //! A.D ad = a.getD();
    // Doesn't return anything but A.D:
    //! A.DImp2 di2 = a.getD();
    // Cannot access a member of the interface:
    //! a.getD().f();
    // Only another A can do anything with getD():
    A a2 = new A();
    a2.receiveD(a.getD());

    A.B b = a2.getB();
    b.f();

    a2.getBf();
  }
} ///:~
