package com.thinkinginjava.string.exercise.chapter13_6;

import com.thinkinginjava.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 19:09
 * @Version: 1.0
 * @Description: page 309
 * 练习18：编写一个程序，读取一个Java源代码文件（可以通过控制台参数提供文件名），
 * 打印出代码中所有的普通字符串。
 */
public class Ex18 {
    public static void main(String[] args) {
        /* 注释1 */
        //注释2
        String regex = "\".*\"";
        String fileName = "src\\com\\thinkinginjava\\string\\exercise\\chapter13_6\\Ex18.java";
        System.out.println("正则表达式: " + regex);

        StringBuilder sb = new StringBuilder();
        for (String line : new TextFile(fileName))
            sb.append(line + "\n");

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sb.toString());
        System.out.println("普通字符串:");
        while (m.find())
            System.out.println(m.group());
    }
}
/**output:
 * 正则表达式: ".*"
 * 普通字符串:
 * "\".*\""
 * "src\\com\\thinkinginjava\\string\\exercise\\chapter13_6\\Ex18.java"
 * "正则表达式: "
 * "\n"
 * "普通字符串:"
 */