package com.thinkinginjava.type_information.example.chapter14_9;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 */
class B implements A {
    @Override
    public void f() {}
    public void g() {}
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        //! a.g(); // 编译错误
        System.out.println(a.getClass().getSimpleName());
        if (B.class.isInstance(a)) {
          B b = (B) a;
          b.g();
        }
    }
}
/**output:
 * B
 */