package com.thinkinginjava.inner_classes.exercise.chapter10_3;

/**
 * @Author: monika
 * @Date: 2018/11/29 22:06
 * @Version: 1.0
 * @Description: page 194
 * 练习05：创建一个包含内部类的类，在另一个独立的类中，创建此内部类的实例。
 */
class Outer {
    class Inner {
        Inner() { System.out.println("Outer.Inner()"); }
    }
}

public class Ex05 {
    public static void main(String[] args) {
        // must first create outer class object:
        Outer o = new Outer();
        // then create inner class object:
        Outer.Inner oi = o.new Inner();
    }
}
/**输出：
 * Outer.Inner()
 */