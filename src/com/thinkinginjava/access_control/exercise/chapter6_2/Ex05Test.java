package com.thinkinginjava.access_control.exercise.chapter6_2;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:58
 * @Version: 1.0
 * @Description:
 */
public class Ex05Test {
    public static void main(String[] args) {
        Ex05 ex05 = new Ex05();
        ex05.showa();
        ex05.showb();
        ex05.showc();
        ex05.a = 10;
        ex05.b = 20;
        ex05.c = 30;
        ex05.showa();
        ex05.showb();
        ex05.showc();
        //! ex05.showd(); // private access, compiler can't touch
    }
}
/**输出：
 * Ex05() constructor
 * 1
 * 2
 * 3
 * 10
 * 20
 * 30
 */