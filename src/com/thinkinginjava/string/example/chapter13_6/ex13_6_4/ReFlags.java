package com.thinkinginjava.string.example.chapter13_6.ex13_6_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 12:21
 * @Version: 1.0
 * @Description:
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java",
                // CASE_INSENSITIVE:忽略大小写的模式
                // MULTILINE:多行模式，一行一行的进行匹配。\n为换行符
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java");
        while(m.find())
            System.out.println(m.group());
    }
}
/**output:
 * java
 * Java
 * JAVA
 */