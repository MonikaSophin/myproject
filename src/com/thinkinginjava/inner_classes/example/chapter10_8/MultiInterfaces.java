package com.thinkinginjava.inner_classes.example.chapter10_8;

/**
 * @Author: monika
 * @Date: 2018/12/8 21:27
 * @Version: 1.0
 * @Description:
 * 1.每个内部类都能独立地继承自一个（接口的）实现，所以无论外围类是否已经继承了某个
 * （接口的）实现，对于内部类都没有影响。
 * 2.如果没有内部类提供的，可以继承多个具体的或抽象类的能力，一些设计与编程问题就很
 * 难解决。内部类有效地实现了“多重继承”。也就是说，内部类允许继承多个非接口类型（类
 * 或抽象类）。
 * {①如果实现的是不同的接口，可以使用单一类去实现不同的接口，也可以使用内部类去分别实现接口。
 *  ②如果继承的是不同的抽象类或是类，只能通过内部类去继承不同的类或抽象类。
 *
 */
interface A{ void methodA();}
interface B{ void methodB();}

class X implements A,B{
    @Override
    public void methodA() { System.out.println("X#methodA()"); }
    @Override
    public void methodB() { System.out.println("X#methodB()"); }
}

class Y implements A{
    @Override
    public void methodA() { System.out.println("Y#methodA()"); }
    B makeB(){
      return () ->System.out.println("Y#methodB()");
    }
}

public class MultiInterfaces {
    static void takesA(A a){ a.methodA(); }
    static void takesB(B b){ b.methodB(); }
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesB(x);
        takesA(y);
        takesB(y.makeB());
    }
}
/**输出：
 * X#methodA()
 * X#methodB()
 * Y#methodA()
 * Y#methodB()
 */