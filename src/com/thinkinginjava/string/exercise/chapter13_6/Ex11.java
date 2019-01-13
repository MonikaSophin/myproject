package com.thinkinginjava.string.exercise.chapter13_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/12 19:29
 * @Version: 1.0
 * @Description: page 301
 * 练习11：试用正则表达式
 * (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 * 匹配字符串
 * Arline ate eight apples and one orange while Anita hadn't any
 */
public class Ex11 {
    public static void main(String[] args) {
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String string = "Arline ate eight apples and one orange while Anita hadn't any";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        System.out.println("regex: \"" + regex + "\"");
        while(m.find()){
            System.out.println("match: \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1));
        }
    }
}
/**output:
 * regex: "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
 * match: "Arline" at positions 0-5
 * match: " ate" at positions 6-9
 * match: " one" at positions 27-30
 * match: " orange" at positions 31-37
 * match: " Anita" at positions 44-49
 */