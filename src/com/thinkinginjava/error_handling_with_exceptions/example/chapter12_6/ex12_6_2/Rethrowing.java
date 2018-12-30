package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2;

/**
 * @Author: monika
 * @Date: 2018/12/27 23:12
 * @Version: 1.0
 * @Description:
 * 1.fillInStackTrace(); 将异常抛出点更新为当前异常抛出点。
 */
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("Originating the Exception in f()");
        throw new Exception("throw from f()");
    }
    public static void g() throws Exception {
        try{
            f();
        }catch (Exception e) {
            System.out.println("Inside g().e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception {
        try{
            f();
        }catch (Exception e) {
            System.out.println("Inside h().e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        System.out.println();

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

    }
}
/**output:
 * Originating the Exception in f()
 * Inside g().e.printStackTrace()
 * java.lang.Exception: throw from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.f(Rethrowing.java:12)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.g(Rethrowing.java:16)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.main(Rethrowing.java:35)
 * main: printStackTrace()
 * java.lang.Exception: throw from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.f(Rethrowing.java:12)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.g(Rethrowing.java:16)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.main(Rethrowing.java:35)
 *
 * Originating the Exception in f()
 * Inside h().e.printStackTrace()
 * java.lang.Exception: throw from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.f(Rethrowing.java:12)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.h(Rethrowing.java:25)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.main(Rethrowing.java:44)
 * main: printStackTrace()
 * java.lang.Exception: throw from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.h(Rethrowing.java:29)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.Rethrowing.main(Rethrowing.java:44)
 */