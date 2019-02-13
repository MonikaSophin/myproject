package com.thinkinginjava.generics.exercise.chapter15_9;

/**
 * @Author: monika
 * @Date: 2019/2/13 21:42
 * @Version: 1.0
 * @Description: page 389
 * 练习25：创建两个接口和一个实现了这两个接口的类。创建两个泛型方法，其中一个的
 * 参数边界被限定为第一个接口，而另一个的参数边界被限定为第二个接口。创建实现了
 * 这两个接口的类的实例，并展示它可以用于这两个泛型方法。
 */
interface A { void a(); }

interface B { void b(); }

class C1 implements A {
    public void a() { System.out.println("C1.a();"); }
}

class C2 implements B {
    public void b() { System.out.println("C2.b();"); }
}

class C3 implements A, B {
    public void a() { System.out.println("C3.a();"); }
    public void b() { System.out.println("C3.b();"); }
}

public class Ex25 {
    static <T extends A> void f1(T t) { t.a(); }
    static <T extends B> void f2(T t) { t.b(); }
    static <T extends A & B> void f3(T t) {
        t.a();
        t.b();
    }

    public static void main(String[] args) {
        C1 c1 = new C1();
        f1(c1);
        //! f2(c1);
        //! f3(c1);
        System.out.println();

        C2 c2 = new C2();
        //！f1(c2);
         f2(c2);
        //! f3(c2);
        System.out.println();

        C3 c3 = new C3();
        f1(c3);
        f2(c3);
        f3(c3);
    }
}
/**output:
 * C1.a();
 *
 * C2.b();
 *
 * C3.a();
 * C3.b();
 * C3.a();
 * C3.b();
 */