package com.thinkinginjava.Initialize_clean.exercise.chapter5_3;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:17
 * @Version: 1.0
 * @Description: page 83
 * 练习04：为前一个练习中的类添加一个重载构造器，令其接受一个字符串参数，并在构
 * 造器中把你自己的消息和接受的参数一起打印出来。
 */
public class Ex04 {
    public Ex04() {
        System.out.println("无参构造器:" + this.getClass().getSimpleName());
    }public Ex04(String s) {
        System.out.println("重载的带参构造器: " + s);
    }

    public static void main(String[] args) {
        new Ex04();
        new Ex04("Ex04重载构造器");
    }
}
/**输出：
 * 无参构造器:Ex04
 * 重载的带参构造器: Ex04重载构造器
 */