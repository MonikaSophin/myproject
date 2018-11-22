package com.thinkinginjava.polymorphism.exercise.chapter8_2;

/**
 * @Author: monika
 * @Date: 2018/11/20 22:05
 * @Version: 1.0
 * @Description: page 155
 * 练习10：创建一个包含两个方法的基类。在第一个方法中可以调用第二个方法。然后产生
 * 一个继承自该基类的导出类，且覆盖基类中的第二个方法。为该导出类创建一个对象，将它
 * 向上转型到基类型并调用第一个方法，解释发生的情况。
 */
class BasicClass{
    void f1(){ f2(); }
    void f2(){ System.out.println("BasicClass f2()"); }
}

class ExtendsClass extends BasicClass{
    @Override
    void f2() { System.out.println("ExtendsClass f2()"); }
}

public class Ex10 {
    public static void main(String[] args) {
        BasicClass c = new ExtendsClass();
        c.f1();
    }
}
/**输出：
 * ExtendsClass f2()
 *
 *  基类型的引用指向的是导出类的实例，操作的是导出类的方法。
 */