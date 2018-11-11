package com.thinkinginjava.Initialize_clean.exercise.chapter5_4;

import java.util.concurrent.Executors;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:50
 * @Version: 1.0
 * @Description: page 86
 * 练习09：编写具有两个（重载）构造器的类，并在第一个构造器中通过this调用第二个构造器。
 */
public class Ex09 {
    Ex09(){
        this("调用重载构造器");
        System.out.println("默认构造器");
    }
    Ex09(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new Ex09();
    }
}
/**输出：
 * 调用重载构造器
 * 默认构造器
 */