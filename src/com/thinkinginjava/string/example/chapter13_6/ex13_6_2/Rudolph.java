package com.thinkinginjava.string.example.chapter13_6.ex13_6_2;

/**
 * @Author: monika
 * @Date: 2019/1/12 14:00
 * @Version: 1.0
 * @Description:
 */
public class Rudolph {
    public static void main(String[] args) {
        String[] strings =
                {"Rudolph",
                "[rR]udolph",
                "[rR][aeiou][a-z]ol.*",
                "R.*"};
        for (String string : strings) {
            System.out.println("Rudolph".matches(string));
        }
    }
}
/**output:
 * true
 * true
 * true
 * true
 */