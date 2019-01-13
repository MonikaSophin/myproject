package com.thinkinginjava.string.exercise.chapter13_6;

import com.thinkinginjava.string.example.chapter13_6.ex13_6_1.Splitting;

import java.util.Arrays;

/**
 * @Author: monika
 * @Date: 2019/1/12 13:42
 * @Version: 1.0
 * @Description: page 297
 * 练习08：将字符串Splitting.knights在the和you处分割。
 */
public class Ex08 {
    static String knights =
            "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void main(String[] args) {
        String[] split = knights.split("the|you");
        System.out.println(Arrays.toString(split));
    }
}
/**output:
 * [Then, when ,  have found ,  shrubbery, ,  must cut down ,  mightiest tree in ,  forest... with... a herring!]
 */