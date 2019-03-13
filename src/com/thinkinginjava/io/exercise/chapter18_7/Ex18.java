package com.thinkinginjava.io.exercise.chapter18_7;

import com.thinkinginjava.util.TextFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 547
 * 练习18:修改{@link TextFile}，使其可以将IOException传递给调用者。
 * 将异常在方法做出异常声明即可。
 */
class TextFile18 extends ArrayList<String> {
    // 将文件作为单个字符串读取:
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()));
        try {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    //在一个方法调用中写入单个文件:
    public static void write(String fileName, String text) throws IOException {
        PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile());
        try {
            out.print(text);
        } finally {
            out.close();
        }
    }

    // 读取文件，按任何正则表达式拆分:
    public TextFile18(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        // 正则表达式split（）经常在第一个位置留下一个空String:
        if (get(0).equals("")) remove(0);
    }

    // 通常按行阅读:
    public TextFile18(String fileName) throws IOException{ this(fileName, "\n"); }

    public void write(String fileName) throws IOException{
        PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile());
        try {
            for (String item : this)
                out.println(item);
        } finally {
            out.close();
        }
    }
}

public class Ex18 {
    public static void main(String[] args) {
        //略~
    }
}