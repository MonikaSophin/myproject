package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6;

/**
 * @Author: monika
 * @Date: 2018/12/27 22:06
 * @Version: 1.0
 * @Description: page 263
 * 练习11：重复上一个练习，但是在catch子句里把g()要抛出的异常包装成一个RuntimeException。
 */
class MyException6 extends Exception {
    public MyException6(String message) { super(message); }
}

class MyException7 extends Exception {
    public MyException7(String message) { super(message); }
}

public class Ex11 {
    static void g() throws MyException6 {
        System.out.println("g()");
        throw new MyException6("throw MyException6 from g()");
    }
    static void f() {
        System.out.println("f()");
        try {
            g();
        } catch (MyException6 e) {
            System.out.println("Caught MyException6 from f() try: ");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
            f();
    }
}
/**output (30% match):
 * f()
 * g()
 * Caught MyException6 from f() try:
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException6: throw MyException6 from g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.g(Ex11.java:21)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.f(Ex11.java:26)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.main(Ex11.java:35)
 * Exception in thread "main" java.lang.RuntimeException: com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException6: throw MyException6 from g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.f(Ex11.java:30)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.main(Ex11.java:35)
 * Caused by: com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException6: throw MyException6 from g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.g(Ex11.java:21)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex11.f(Ex11.java:26)
 */