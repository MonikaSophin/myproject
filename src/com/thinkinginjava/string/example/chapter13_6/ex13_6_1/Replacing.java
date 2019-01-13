package com.thinkinginjava.string.example.chapter13_6.ex13_6_1;

/**
 * @Author: monika
 * @Date: 2019/1/12 13:24
 * @Version: 1.0
 * @Description:
 */
public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        //单词f开头+一个或多个单词
        System.out.println(s.replaceFirst("f\\w+","located"));
        //三个单词中的任意一个。|表示逻辑或
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
/**output:
 * Then, when you have located the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
 * Then, when you have found the banana, you must cut down the mightiest banana in the forest... with... a banana!
 */