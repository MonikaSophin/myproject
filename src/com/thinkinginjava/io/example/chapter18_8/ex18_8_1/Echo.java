package com.thinkinginjava.io.example.chapter18_8.ex18_8_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = in.readLine()) != null && s.length() != 0)
            System.out.println(s);
    }
}
/**output:
 * 略~
 */