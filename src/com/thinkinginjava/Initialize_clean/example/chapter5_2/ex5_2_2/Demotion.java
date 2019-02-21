package com.thinkinginjava.Initialize_clean.example.chapter5_2.ex5_2_2;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:03
 * @Version: 1.0
 * @Description:  如果传入的数据类型(实际参数类型)小于方法中声明的形式参数类型，实际数据类型就会被提升。
 *                char型略有不同，如果无法找到恰好接受char参数的方法，就会把char直接提升至int型。
 *               如果传入的实际参数较大，就得通过类型转换来执行窄化转换。如果不这样做，编译器就会报错。
 */
public class Demotion {
    void f1(char x) {
        Print.print("f1(char)");
    }

    void f1(byte x) {
        Print.print("f1(byte)");
    }

    void f1(short x) {
        Print.print("f1(short)");
    }

    void f1(int x) {
        Print.print("f1(int)");
    }

    void f1(long x) {
        Print.print("f1(long)");
    }

    void f1(float x) {
        Print.print("f1(float)");
    }

    void f1(double x) {
        Print.print("f1(double)");
    }

    void f2(char x) {
        Print.print("f2(char)");
    }

    void f2(byte x) {
        Print.print("f2(byte)");
    }

    void f2(short x) {
        Print.print("f2(short)");
    }

    void f2(int x) {
        Print.print("f2(int)");
    }

    void f2(long x) {
        Print.print("f2(long)");
    }

    void f2(float x) {
        Print.print("f2(float)");
    }

    void f3(char x) {
        Print.print("f3(char)");
    }

    void f3(byte x) {
        Print.print("f3(byte)");
    }

    void f3(short x) {
        Print.print("f3(short)");
    }

    void f3(int x) {
        Print.print("f3(int)");
    }

    void f3(long x) {
        Print.print("f3(long)");
    }

    void f4(char x) {
        Print.print("f4(char)");
    }

    void f4(byte x) {
        Print.print("f4(byte)");
    }

    void f4(short x) {
        Print.print("f4(short)");
    }

    void f4(int x) {
        Print.print("f4(int)");
    }

    void f5(char x) {
        Print.print("f5(char)");
    }

    void f5(byte x) {
        Print.print("f5(byte)");
    }

    void f5(short x) {
        Print.print("f5(short)");
    }

    void f6(char x) {
        Print.print("f6(char)");
    }

    void f6(byte x) {
        Print.print("f6(byte)");
    }

    void f7(char x) {
        Print.print("f7(char)");
    }

    void testDouble() {
        double x = 0;
        Print.print("double argument:");
        f1(x);
        f2((float) x);
        f3((long) x);
        f4((int) x);
        f5((short) x);
        f6((byte) x);
        f7((char) x);
    }

    public static void main(String[] args) {
        Demotion p = new Demotion();
        p.testDouble();
    }
}
/**输出：
 * double argument:
 * f1(double)
 * f2(float)
 * f3(long)
 * f4(int)
 * f5(short)
 * f6(byte)
 * f7(char)
 */