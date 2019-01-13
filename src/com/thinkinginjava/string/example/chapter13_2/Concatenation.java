package com.thinkinginjava.string.example.chapter13_2;

/**
 * @Author: monika
 * @Date: 2018/12/31 14:43
 * @Version: 1.0
 * @Description:
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
/**output:
 * abcmangodef47
 */