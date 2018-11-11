package com.thinkinginjava.Initialize_clean.exercise.chapter5_7;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:29
 * @Version: 1.0
 * @Description: page 97
 * 练习14：编写一个类，拥有两个惊天字符串域，其中一个在定义处初始化，另一个在静
 * 态块中初始化。现在，加入一个静态方法用以打印出两个字段值。请证明它们都会在被使用之
 * 前完成初始化动作。
 */
class Apple {
    static String s1 = "静态成员变量s1";
    static String s2;
    static {
        s2 = "静态成员变量s2";
        System.out.println("初始化:s1 " + s1 + "   s2" + s2);
    }
    static void f() {
        System.out.println(s1 + "   " + s2);
    }
    public Apple() {
        System.out.println("构造器Apple()");
    }
}

public class Ex14 {
    public static void main(String[] args) {
        System.out.println("main start");
        Apple.f();
    }
    static Apple apple = new Apple();
}
/**输出：
 * 初始化:s1 静态成员变量s1   s2静态成员变量s2
 * 构造器Apple()
 * main start
 * 静态成员变量s1   静态成员变量s2
 */