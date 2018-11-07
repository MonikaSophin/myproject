package com.thinkinginjava.Initialize_clean.exercise.chapter5_1;

/**
 * @Author: monika
 * @Date: 2018/11/7 22:08
 * @Version: 1.0
 * @Description: page 77
 * 练习01：
 * 创建一个类，它包含一个未初始化的String引用。验证该引用被Java初始化成了null。
 */
class Clazz{
    String s;
    public Clazz() {
        System.out.println("引用s: "+s);
    }
}
public class Ex01 {
    public static void main(String[] args) {
        new Clazz();
    }
}
/**输出：
 * 引用s: null
 */