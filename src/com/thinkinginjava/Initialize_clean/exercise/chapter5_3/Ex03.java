package com.thinkinginjava.Initialize_clean.exercise.chapter5_3;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:14
 * @Version: 1.0
 * @Description: page 83
 * 练习03：创建一个带默认构造器（即无参构造器）的类，在构造器中打印一条消息。为
 * 这个类创建一个对象。
 */
public class Ex03 {
    public Ex03() {
        System.out.println("无参构造器:" + this.getClass().getSimpleName());
    }
    public static void main(String[] args) {
        new Ex03();
    }
}
/**输出：
 * 无参构造器:Ex04
 */