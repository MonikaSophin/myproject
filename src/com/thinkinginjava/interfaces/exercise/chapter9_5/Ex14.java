package com.thinkinginjava.interfaces.exercise.chapter9_5;

/**
 * @Author: monika
 * @Date: 2018/11/26 21:22
 * @Version: 1.0
 * @Description: page 181
 * 练习14：创建三个接口，每个接口都包含两个方法。继承出一个接口，它组合了这三个
 * 接口并添加了一个新方法。创建一个实现了这新接口并且继承了某个具体类的类。现在
 * 编写四个方法，每一个都接受这四个接口之一作为参数。在main()方法中，创建这个类
 * 的对象，并将其传递给这四个方法。
 */
interface Interface1{ void f1();}

interface Interface2{ void f2();}

interface Interface3{ void f3();}

interface Interface4 extends Interface1,Interface2,Interface3{ void f4();}

class Clazz1{ void c(){ }}

class Clazz2 extends Clazz1 implements Interface4{
    @Override
    public void f1() { }
    @Override
    public void f2() { }
    @Override
    public void f3() { }
    @Override
    public void f4() { }
}

public class Ex14 {
    static void x1(Interface1 interface1){ interface1.f1(); }
    static void x2(Interface2 interface2){ interface2.f2(); }
    static void x3(Interface3 interface3){ interface3.f3(); }
    static void x4(Interface4 interface4){ interface4.f4(); }

    public static void main(String[] args) {
        Clazz2 clazz2 = new Clazz2();
        x1(clazz2);
        x2(clazz2);
        x3(clazz2);
        x4(clazz2);
    }
}
