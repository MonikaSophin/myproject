package com.thinkinginjava.reusing_classes.example.chapter7_8.ex7_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/17 19:48
 * @Version: 1.0
 * @Description: final参数
 *             1. java允许在参数列表中以声明的方式将参数指明为final。
 *             这意味着你无法再方法中更改参数引用所指向的对象。
 *             2. 方法f()和g()展示了当基本类型的参数被指明为final时
 *             所出现的结果，你可以读参数，但却无法修改参数。
 *             3. 这个final参数的特性主要用来向匿名内部类传递数据。
 */
class Gizmo {
    public void spin() {}
}

public class FinalArguments {
    void with(final Gizmo g) {
        //! g = new Gizmo(); // Illegal -- g is final
    }
    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }
    // void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive:
    int g(final int i) { return i + 1; }
    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}
