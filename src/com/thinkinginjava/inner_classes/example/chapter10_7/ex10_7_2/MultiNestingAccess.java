package com.thinkinginjava.inner_classes.example.chapter10_7.ex10_7_2;

/**
 * @Author: monika
 * @Date: 2018/12/8 20:51
 * @Version: 1.0
 * @Description:
 *  1.一个内部类被嵌套多少层并不重要——他能透明地访问所有它所嵌入的外围类的所有成员，
 *    如下所示：
 */
class MNA{
    private void f(){ System.out.println("MNA#f()"); }
    class A{
        private void g(){ System.out.println("MNA$A#g()"); }
        public class B{
            void h(){
                System.out.println("MNA$A$B#h()");
                g();
                f();
            }
        }
    }
}

/**
 * 2.可以看到在MNA.A.B中，调用方法g()和f()不需要任何条件（即使它们被定义为private）。
 * 这个例子同时显示了如何从不同的类里创建多层嵌套的内部类对象的基本语法。".new"语法能
 * 产生正确的作用域，所以不必在调用构造器时限定类名。
 */
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
/**输出：
 * MNA$A$B#h()
 * MNA$A#g()
 * MNA#f()
 */