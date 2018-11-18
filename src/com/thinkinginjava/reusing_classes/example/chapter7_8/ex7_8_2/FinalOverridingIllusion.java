package com.thinkinginjava.reusing_classes.example.chapter7_8.ex7_8_2;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:11
 * @Version: 1.0
 * @Description: final方法
 *              1.使用final方法有两个原因：一是把方法锁定，以防任何继承类修改它的含义。
 *                                     二是效率，
 *              2.类中所有的private方法都隐式地指定为是final的。由于无法取用private
 *              方法所以也就无法覆盖它。可以对private方法添加final修饰词，但这并不能
 *              给该方法增加任何额外的意义。
 *              3.“覆盖”只有在某方法是基类的接口的一部分时才会出现。即，必须能将一个对象
 *              向上转型为它的基本类型并调用相同的方法。
 */
class WithFinals {
    // Identical to "private" alone:
    private final void f() { System.out.println("WithFinals.f()"); }
    // Also automatically "final":
    private void g() { System.out.println("WithFinals.g()"); }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }
    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }
    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();

    }
}
/** 输出:
OverridingPrivate2.f()
OverridingPrivate2.g()
*/
