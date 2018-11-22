package com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_4;

/**
 * @Author: monika
 * @Date: 2018/11/20 22:15
 * @Version: 1.0
 * @Description: 结论：由于private方法被自动认为是final方法，而且对导出类是屏蔽的。
 *                 只有非private方法才可以被覆盖；但是还需要密切注意覆盖private方法
 *                 的现象，这时虽然编译器不会报错，但是也不会按照我们所期望的来执行。
 *                 确切地说，在导出类中，对于基类中的private方法，最好采用不同的名字。
 */
public class PrivateOverride {
    private void f() { System.out.println("private f()"); }
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {
    public void f() { System.out.println("public f()"); }
}
/** Output:
private f()
*/
