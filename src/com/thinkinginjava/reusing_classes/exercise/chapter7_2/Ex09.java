package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:55
 * @Version: 1.0
 * @Description: page 130
 * 练习09：创建一个Root类，令其含有名为Component1、Component2、Component3的
 * 类的各一个实例（这些也由你写）。从Root中派生一个类Stem，也含有上述各“组成部分”。
 * 所有的类都应带有可打印出来类的相关信息的默认构造器。
 */
class Component1 {
    Component1() { System.out.println("Component1()"); }
}

class Component2 {
    Component2() { System.out.println("Component2()"); }
}

class Component3 {
    Component3() { System.out.println("Component3()"); }
}

class Root {
    Component1 c1root = new Component1();
    Component2 c2root = new Component2();
    Component3 c3root = new Component3();
    Root() { System.out.println("Root()"); }
}

class Stem extends Root {
    Component1 c1stem = new Component1();
    Component2 c2stem = new Component2();
    Component3 c3stem = new Component3();
    Stem() { System.out.println("Stem()"); }
}

public class Ex09 {
    public static void main(String[] args) {
        new Stem();
    }
}
/**输出：
 * Component1()
 * Component2()
 * Component3()
 * Root()
 * Component1()
 * Component2()
 * Component3()
 * Stem()
 *
 * 结论：
 *  先初始化基类成员，然后初始化基类的构造器，再初始化自身成员，然后初始化自身构造器。
 */
