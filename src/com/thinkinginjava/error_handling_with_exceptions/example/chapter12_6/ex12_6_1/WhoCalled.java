package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_1;

/**
 * @Author: monika
 * @Date: 2018/12/27 23:02
 * @Version: 1.0
 * @Description:
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
        }
    }
    static void g() {f();}
    static void h() {g();}

    public static void main(String[] args) {
        f();
        System.out.println("---------------------------------------");
        g();
        System.out.println("---------------------------------------");
        h();
    }
}
/**output:
 * f
 * main
 * ---------------------------------------
 * f
 * g
 * main
 * ---------------------------------------
 * f
 * g
 * h
 * main
 */