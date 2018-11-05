package com.thinkinginjava.controlling_execution.example.chapter4_4;

/**
 * @Author: monika
 * @Date: 2018/11/5 21:48
 * @Version: 1.0
 * @Description:
 */
public class ForEachString {
    public static void main(String[] args) {
        for (char c : "An African Swallow".toCharArray())
            System.out.print(c + " ");
    }
}
/**输出：
 * A n   A f r i c a n   S w a l l o w
 */