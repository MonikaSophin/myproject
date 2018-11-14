package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:47
 * @Version: 1.0
 * @Description: page 130
 * 练习05：创建两个带有默认构造器（空参数列表）的类A和类B。从A中继承产生一个名为C
 * 的新类，并在C内创建一个B类的成员。不要给C编写构造器。创建一个C类的对象并观察结果。
 */
class A{
    public A() {
        System.out.println("A()");
    }
}
class B{
    public B() {
        System.out.println("B()");
    }
}
class C extends A{
    public B b = new B();
}

public class Ex05 {
    public static void main(String[] args) {
        new C();
    }
}
/**输出：
 * A()
 * B()
 */