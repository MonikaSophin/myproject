package com.thinkinginjava.string.exercise.chapter13_6;

import java.util.Arrays;

/**
 * @Author: monika
 * @Date: 2019/1/13 17:23
 * @Version: 1.0
 * @Description: page 306
 * 练习14：用String.split()重写SplitDemo。
 */
public class Ex14 {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(
                input.split("!!")));
        System.out.println(Arrays.toString(
                input.split("!!",3)));
    }
}
/**output:
 * [This, unusual use, of exclamation, points]
 * [This, unusual use, of exclamation!!points]
 */