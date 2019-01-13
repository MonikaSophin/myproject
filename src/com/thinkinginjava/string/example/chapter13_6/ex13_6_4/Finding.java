package com.thinkinginjava.string.example.chapter13_6.ex13_6_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/12 19:40
 * @Version: 1.0
 * @Description: {@link Matcher#find()}可以用来在CharSequence中查找多个匹配。
 */
public class Finding {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher("Evening is full of the linnet's wings");

        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();

        int i = 0;
        while (m.find(i)){
            System.out.print(m.group() + " ");
            i++;
        }
    }
}
/**output:
 * Evening is full of the linnet s wings
 * Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
 */
