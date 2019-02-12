package com.thinkinginjava.generics.exercise.chapter15_7;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description: page 375
 * 练习20: 创建一个具有两个方法的接口，以及一个是实现了这个接口并添加了另一个方法的
 * 类。在另一个类中，创建一个泛型方法，它的参数类型由这个接口定义了边界，并展示该接口
 * 中的方法在这个泛型方法中都是可调用的。在main()方法中的传递一个实现类的实例给这个
 * 泛型方法。
 */
interface A {
    void f1();
    void f2();
}

class B implements A {
    @Override
    public void f1() { System.out.println("B.f1()"); }
    @Override
    public void f2() { System.out.println("B.f2()"); }
    public void f3() { System.out.println("B.f3()"); }
}

class C <T extends A>{
    public void f(T a) {
        a.f1();
        a.f2();
    }
}

public class Ex20 {
    public static void main(String[] args) {
        C<A> c = new C<>();
        B b = new B();
        c.f(b);
        System.out.println();

        b.f1();
        b.f2();
        b.f3();
    }
}
/**output:
 * B.f1()
 * B.f2()
 *
 * B.f1()
 * B.f2()
 * B.f3()
 */