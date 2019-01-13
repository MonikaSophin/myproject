package com.thinkinginjava.string.example.chapter13_6.ex13_6_5;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 17:18
 * @Version: 1.0
 * @Description:
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input,3)));
    }
}
/**output:
 * [This, unusual use, of exclamation, points]
 * [This, unusual use, of exclamation!!points]
 */