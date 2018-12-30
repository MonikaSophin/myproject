package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_7;

/**
 * @Author: monika
 * @Date: 2018/12/28 21:52
 * @Version: 1.0
 * @Description:
 * 1.RuntimeException(及其子类异常)是一个特例。对于这种异常类型，
 * 编译器不需要异常说明，其输出被报告给了System.err。
 * 2.RuntimeException(及其子类异常)没有被捕获而直达main()，那么
 * 在程序退出前将调用异常的printStackTrace()方法。
 * 3.RuntimeException(及其子类异常)也可以使用try-catch子句进行捕获。
 */
public class NeverCaught {
    static void f() { throw new RuntimeException("from f()"); }
    static void g() { f(); }

    public static void main(String[] args) {
        try{
            g();
        }catch (RuntimeException e){
            System.out.println("runtime exception");
        }
        g();
    }
}
/**
 * output:
 * runtime exception
 * Exception in thread "main" java.lang.RuntimeException: from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_7.NeverCaught.f(NeverCaught.java:15)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_7.NeverCaught.g(NeverCaught.java:16)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_7.NeverCaught.main(NeverCaught.java:24)
 */