package com.thinkinginjava.string.example.chapter13_6.ex13_6_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 17:26
 * @Version: 1.0
 * @Description:
 * Matcher#reset(): 可以将现有的Matcher对象应用于一个新的字符序列。
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();

        m.reset("fix the rig with rags");
        while (m.find())
            System.out.print(m.group() + " ");

    }
}
/**output:
 * fix rug bag
 * fix rig rag
 */