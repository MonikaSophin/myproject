package com.thinkinginjava.string.example.chapter13_6.ex13_6_1;

import java.util.Arrays;

/**
 * @Author: monika
 * @Date: 2019/1/12 13:17
 * @Version: 1.0
 * @Description:
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";
    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");//空格 分隔
        split("\\W+");//一个或多个非单词 分隔
        split("n\\W+");//单词n+一个或多个非单词 分隔
    }
}
/**output:
 * [Then,, when, you, have, found, the, shrubbery,, you, must, cut, down, the, mightiest, tree, in, the, forest..., with..., a, herring!]
 * [Then, when, you, have, found, the, shrubbery, you, must, cut, down, the, mightiest, tree, in, the, forest, with, a, herring]
 * [The, whe, you have found the shrubbery, you must cut dow, the mightiest tree i, the forest... with... a herring!]
 */