package com.thinkinginjava.string.example.chapter13_8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @Author: monika
 * @Date: 2019/1/12 18:32
 * @Version: 1.0
 * @Description: StringTokenizer 基本弃用，可以使用Scanner与正则表达式来进行分词操作。
 */
public class ReplacingStringTokenizer {
    public static void main(String[] args) {
        String input = "But I'm not dead yet! I feel happy!";

        StringTokenizer stoke = new StringTokenizer(input);
        while(stoke.hasMoreElements())
            System.out.print(stoke.nextToken() + " ");
        System.out.println();

        System.out.println(Arrays.toString(input.split(" ")));

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
    }
}
/**output:
 * But I'm not dead yet! I feel happy!
 * [But, I'm, not, dead, yet!, I, feel, happy!]
 * But I'm not dead yet! I feel happy!
 */