package com.thinkinginjava.string.exercise.chapter13_6;

/**
 * @Author: monika
 * @Date: 2019/1/12 13:29
 * @Version: 1.0
 * @Description: page 297
 * 练习07：请参考java.util.regex.Pattern的文档，编写一个正则表达式，检查一个句子是否
 * 以大写字母开头，以句号结尾。
 */
public class Ex07 {
    static boolean match(String s){
        //大写字母[A-Z]开头，[\.]结尾，.*中间0或多个任意字符
        boolean result = s.matches("^[A-Z].*[\\.]$");
        return result;
    }

    public static void main(String[] args) {
        System.out.println(match("A."));
        System.out.println(match("Abc."));
        System.out.println(match("A b c."));
        System.out.println(match("ABcD."));
        System.out.println(match("aBcd."));
        System.out.println(match("ABcd"));
    }
}
/**output:
 * true
 * true
 * true
 * true
 * false
 * false
 */