package com.thinkinginjava.Initialize_clean.exercise.chapter5_1;

/**
 * @Author: monika
 * @Date: 2018/11/7 22:12
 * @Version: 1.0
 * @Description: page 77
 * 练习02：创建一个类，它包含一个在定义时就被初始化了的String域，以及另一个通过
 * 构造器初始化的String域。这两种方式有何差异
 */
class Clazz2 {
    String s1 = "定义时初始化";
    String s2;
    String s3;
    public Clazz2() {
        s2 = "构造器内初始化";
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Clazz2 clazz2 = new Clazz2();
        System.out.println("clazz2.s1 = " + clazz2.s1);
        System.out.println("clazz2.s2 = " + clazz2.s2);
        System.out.println("clazz2.s3 = " + clazz2.s3);
    }
}
/**输出：
 * clazz2.s1 = 定义时初始化
 * clazz2.s2 = 构造器内初始化
 * clazz2.s3 = null
 */