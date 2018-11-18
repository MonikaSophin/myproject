package com.thinkinginjava.reusing_classes.exercise.chapter7_9;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:47
 * @Version: 1.0
 * @Description: page 147
 * 练习23：请证明加载类的动作仅发生一次。证明该类的第一个实体的创建或者对static
 * 成员的访问都有可能引起加载。
 */
class A {
    static int j = printInit("A.j initialized");
    static int printInit(String s) {
        System.out.println(s);
        return 1;
    }
    A() { System.out.println("A() constructor"); }
}

class B extends A {
    static int k = printInit("B.k initialized");
    B() { System.out.println("B() constructor"); }
}

class C {
    static int n = printInitC("C.n initialized");
    static A a = new A();
    C() { System.out.println("C() constructor"); }
    static int printInitC(String s) {
        System.out.println(s);
        return 1;
    }
}

class D {
    D() { System.out.println("D() constructor"); }
}

public class Ex23 extends B {
    static int i = printInit("Ex23.i initialized");
    Ex23() { System.out.println("Ex23() constructor"); }
    public static void main(String[] args) {
        // accessing static main causes loading (and initialization)
        // of A, B, & LoadClass
        System.out.println("hi");
        // call constructors from loaded classes:
        Ex23 ex23 = new Ex23();
        // call to static field loads & initializes C:
        System.out.println(C.a);
        // call to constructor loads D:
        D d = new D();
    }

}
/**输出：
 * A.j initialized
 * B.k initialized
 * Ex23.i initialized
 * hi
 * A() constructor
 * B() constructor
 * Ex23() constructor
 * C.n initialized
 * A() constructor
 * com.thinkinginjava.reusing_classes.exercise.chapter7_9.A@4554617c
 * D() constructo
 */
