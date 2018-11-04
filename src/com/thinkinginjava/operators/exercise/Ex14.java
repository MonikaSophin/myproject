package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.operators.example.chapter3_1.Print;

/**
 * @Author: monika
 * @Date: 2018/11/4 15:56
 * @Version: 1.0
 * @Description: 练习14：编写一个接收两个字符串参数的方法，用各种布尔值的比较关系来比较这两个
 * 字符串，然后把结果打印出来。做==和!=比较的同时，用equals()作测试。在main()里面
 * 用几个不同的字符串对象调用这个方法。
 */
public class Ex14 {
    public static void campare(String s1, String s2) {
        String s = s1 == s2 ? "s1 == s2" : "s1 != s2";
        Print.print(s);
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        campare(s1, s2);
        Print.print(s1.equals(s2) ? "s1 == s2" : "s1 != s2");

        Print.print("------------");
        s1 = new String("a");
        s2 = new String("a");
        campare(s1, s2);
        Print.print(s2.equals(s1) ? "s1 == s2" : "s1 != s2");
    }
}
/**
 * 结果：
 * s1 == s2
 * s1 == s2
 * ------------
 * s1 != s2
 * s1 == s2
 *
 * 问： 两个字符串对象，为什么s1==s2？
 * 答： 因为没有显式的去new String();所以两个直接赋值给s1和s2的字符串常量，是在字符串常量池里进行比较的。
 *   如果是new String();这样的话，==比较的是 对象的引用(堆栈地址)。
 */