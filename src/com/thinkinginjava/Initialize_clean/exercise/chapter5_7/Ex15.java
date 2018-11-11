package com.thinkinginjava.Initialize_clean.exercise.chapter5_7;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:50
 * @Version: 1.0
 * @Description: page 98
 * 练习15：编写一个含有字符串域的类，并采用实例初始化方式进行初始化。
 */
class Tester {
    String s;
    {
        s = "Initializing string in Tester";
        System.out.println(s);
    }
    Tester() {
        System.out.println("Tester()");
    }
}

public class Ex15 {
    public static void main(String[] args) {
        new Tester();
    }
}
/**输出：
 * Initializing string in Tester
 * Tester()
 */
