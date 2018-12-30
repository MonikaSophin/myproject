package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6;

/**
 * @Author: monika
 * @Date: 2018/12/27 22:06
 * @Version: 1.0
 * @Description: page 263
 * 练习10：为一个类定义两个方法：f()和g()。在g()里，抛出一个自定义的新异常。在f()
 * 里，调用g()，捕获它抛出的异常，并且在catch子句里抛出另一个异常（自定义的第二种异常）。
 * 在main()里测试代码。
 */
class MyException4 extends Exception {
    public MyException4(String message) { super(message); }
}

class MyException5 extends Exception {
    public MyException5(String message) { super(message); }
}

public class Ex10 {
    static void g() throws MyException4 {
        System.out.println("g()");
        throw new MyException4("throw MyException4 from g()");
    }
    static void f() throws MyException5 {
        System.out.println("f()");
        try {
            g();
        } catch (MyException4 e) {
            System.out.println("Caught MyException4: ");
            e.printStackTrace(System.out);
            throw new MyException5("throw MyException5 from f()");
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException5 e) {
            System.out.println("Caught MyException5: ");
            e.printStackTrace(System.out);
        }
    }
}
/**output:
 * f()
 * g()
 * Caught MyException4:
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException4: throw MyException4 from g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10.g(Ex10.java:23)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10.f(Ex10.java:28)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10.main(Ex10.java:38)
 * Caught MyException5:
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException5: throw MyException5 from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10.f(Ex10.java:32)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10.main(Ex10.java:38)
 */