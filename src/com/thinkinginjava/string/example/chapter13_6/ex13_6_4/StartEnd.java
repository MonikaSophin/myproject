package com.thinkinginjava.string.example.chapter13_6.ex13_6_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/12 20:21
 * @Version: 1.0
 * @Description:
 * find(): 可以在字符串的任意位置定位正则表达式。
 * lookingAt(): 只有在正则表达式与字符串的最开始处就开始匹配时才会成功。
 *             只要字符串的第一部分匹配就会成功。
 * matches(): 只有在正则表达式与字符串的最开始处就开始匹配时才会成功。
 *            只有在整个字符串都匹配正则表达式时才会成功。
 */
public class StartEnd {
    public static String input =
            "As long as there is injustice, whenever a\n" +
            "Targathian baby cries out, wherever a distress\n" +
            "signal sounds among the stars ... We'll be there.\n" +
            "This fine ship, and this fine crew ...\n" +
            "Never give up! Never surrender!";
    private static class Display {
        private boolean regexprinted = false;
        private String regex;
        public Display(String regex) { this.regex = regex; }
        void display(String message) {
            if (!regexprinted){
                System.out.println(regex);
                regexprinted = true;
            }
            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display("find() '" + m.group() + "' start = " +
                    m.start() + " end = " + m.end());
        if (m.lookingAt())
            d.display("lookingAt() start = " + m.start() +
                    " end = " + m.end());
        if (m.matches())
            d.display("matches() start = " + m.start() +
                    " end = " + m.end());
    }

    public static void main(String[] args) {
        for (String in : input.split("\n")) {
            System.out.println("input: " + in);
            for (String regex : new String[]{"\\w*ere\\w*",
                    "\\w*ever", "T\\w+", "Never.*?!"}) {
                examine(in,regex);
            }
        }
    }
}
/**output:
 * nput: As long as there is injustice, whenever a
 * \w*ere\w*
 * find() 'there' start = 11 end = 16
 * \w*ever
 * find() 'whenever' start = 31 end = 39
 * input: Targathian baby cries out, wherever a distress
 * \w*ere\w*
 * find() 'wherever' start = 27 end = 35
 * \w*ever
 * find() 'wherever' start = 27 end = 35
 * T\w+
 * find() 'Targathian' start = 0 end = 10
 * lookingAt() start = 0 end = 10
 * input: signal sounds among the stars ... We'll be there.
 * \w*ere\w*
 * find() 'there' start = 43 end = 48
 * input: This fine ship, and this fine crew ...
 * T\w+
 * find() 'This' start = 0 end = 4
 * lookingAt() start = 0 end = 4
 * input: Never give up! Never surrender!
 * \w*ever
 * find() 'Never' start = 0 end = 5
 * find() 'Never' start = 15 end = 20
 * lookingAt() start = 0 end = 5
 * Never.*?!
 * find() 'Never give up!' start = 0 end = 14
 * find() 'Never surrender!' start = 15 end = 31
 * lookingAt() start = 0 end = 14
 * matches() start = 0 end = 31
 */