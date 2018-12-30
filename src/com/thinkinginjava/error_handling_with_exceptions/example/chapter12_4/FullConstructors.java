package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:11
 * @Version: 1.0
 * @Description:
 * 1.e.printStackTrace(); 将会把错误发送给标准错误流。
 * e.printStackTrace(PrintStream s); 将会把错误发送给打印流中。
 */
class MyException extends Exception{
    public MyException() { }
    public MyException(String message) { super(message); }
}

public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
/**output:
 * Throwing MyException from f()
 * com.thinkinginjava.error_handling_with_exceptions.chapter12_4.MyException
 * 	at com.thinkinginjava.error_handling_with_exceptions.chapter12_4.FullConstructors.f(FullConstructors.java:17)
 * 	at com.thinkinginjava.error_handling_with_exceptions.chapter12_4.FullConstructors.main(FullConstructors.java:27)
 * Throwing MyException from g()
 * com.thinkinginjava.error_handling_with_exceptions.chapter12_4.MyException: Originated in g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.chapter12_4.FullConstructors.g(FullConstructors.java:22)
 * 	at com.thinkinginjava.error_handling_with_exceptions.chapter12_4.FullConstructors.main(FullConstructors.java:32)
 */