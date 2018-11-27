package com.thinkinginjava.interfaces.exercise.chapter9_4;

/**
 * @Author: monika
 * @Date: 2018/11/26 21:01
 * @Version: 1.0
 * @Description: page 180
 * 练习13：创建一个接口，并从该接口继承两个接口，然后从后面两个接口多重继承第三个接口。
 */
interface Interface{
    void f();
}

interface Interface1 extends Interface{
    void f1();
}

interface Interface2 extends Interface{
    void f2();
}

interface Interface3 extends Interface1,Interface2{
    void f3();
}

class Clazz implements Interface3{
    @Override
    public void f() { System.out.println("f()"); }
    @Override
    public void f1() { System.out.println("f1()"); }
    @Override
    public void f2() { System.out.println("f2()"); }
    @Override
    public void f3() { System.out.println("f3()"); }
}

public class Ex13{
    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        ((Interface)clazz).f();
       //! ((Interface)clazz).f1();

        ((Interface1)clazz).f();
        ((Interface1)clazz).f1();

        ((Interface2)clazz).f();
        ((Interface2)clazz).f2();

        ((Interface3)clazz).f();
        ((Interface3)clazz).f1();
        ((Interface3)clazz).f2();
        ((Interface3)clazz).f3();
    }
}
/**输出：
 * f()
 * f()
 * f1()
 * f()
 * f2()
 * f()
 * f1()
 * f2()
 * f3()
 */