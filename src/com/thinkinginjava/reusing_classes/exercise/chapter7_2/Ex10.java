package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:57
 * @Version: 1.0
 * @Description: page 130
 * 练习10;修改练习9，使每个类都仅具有非默认的构造器。
 */
class Component_1 {
    Component_1(byte b) {
        System.out.println("Component1(byte)"); }
}

class Component_2 {
    Component_2(short s) { System.out.println("Component2(short)"); }
}

class Component_3 {
    Component_3(int i) { System.out.println("Component3(int)"); }
}

class Root10 {
    Component_1 c1root;
    Component_2 c2root;
    Component_3 c3root;
    Root10(float f) {
        c1root = new Component_1((byte)0);
        c2root = new Component_2((short)0);
        c3root = new Component_3(0);
        System.out.println("Root10(foat)");
    }
}

class Stem10 extends Root10 {
    Component_1 c1stem10;
    Component_2 c2stem10;
    Component_3 c3stem10;
    Stem10(double d) {
        super(2.78f);
        c1stem10 = new Component_1((byte)1);
        c2stem10 = new Component_2((short)1);
        c3stem10 = new Component_3(1);
        System.out.println("Stem10(double)");
    }

}

public class Ex10 {
    public static void main(String[] args) {
        new Stem10(2.78);
    }
}
/**输出：
 * Component1(byte)
 * Component2(short)
 * Component3(int)
 * Root10(foat)
 * Component1(byte)
 * Component2(short)
 * Component3(int)
 * Stem10(double)
 */