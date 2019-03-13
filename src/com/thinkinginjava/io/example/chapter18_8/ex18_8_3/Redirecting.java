package com.thinkinginjava.io.example.chapter18_8.ex18_8_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        String srcPath = "src\\com\\thinkinginjava\\io\\example\\chapter18_8\\ex18_8_3\\Redirecting.java";
        String destPath = "src\\com\\thinkinginjava\\io\\example\\chapter18_8\\ex18_8_3\\file\\test.out";
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(srcPath));
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(destPath)));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s);
        out.close();
        System.setOut(console);
    }
}
//~