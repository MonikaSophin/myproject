package com.thinkinginjava.io.example.chapter18_8.ex18_8_2;

import java.io.PrintWriter;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello world!");
    }
}
/**output:
 * Hello world!
 */