package com.thinkinginjava.string.exercise.chapter13_6;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/12 19:56
 * @Version: 1.0
 * @Description: page 303
 * 练习12：修改Groups.java类，找出所有不以大写字母开头的词，不重复地计算其个数。
 */
public class Ex12 {
    public static void main(String[] args) {
        System.out.println("f1():");
        f1();
//        System.out.println("f2():");
//        f2();
    }

    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void f1() {
        // \b为词[a-zA-Z0-9]的边界
        String regex = "\\b([a-z]\\w+)\\b";
        Matcher m = Pattern.compile(regex).matcher(POEM);
        Set<String> words = new TreeSet<>();
        while (m.find())
            words.add(m.group());
        System.out.println("regex = " + regex);
        System.out.println("count = " + words.size());
        System.out.println("words = " + words);
    }

    //错误！！！
//    public static void f2() {
//        String regex = "(^[a-z]|\\s+[a-z])\\w+";
//        Matcher m = Pattern.compile(regex).matcher(POEM);
//        Set<String> words = new TreeSet<>();
//        while (m.find())
//            words.add(m.group());
//        System.out.println("regex = " + regex);
//        System.out.println("count = " + words.size());
//        System.out.println("words = " + words);
//    }
}
/**output:
 * f1():
 * regex = \b([a-z]\w+)\b
 * count = 25
 * words = [and, bird, bite, borogoves, brillig, catch, claws, frumious, gimble, gyre, in, jaws, mimsy, mome, my, outgrabe, raths, shun, slithy, son, that, the, toves, wabe, were]
 */