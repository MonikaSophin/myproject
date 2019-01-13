package com.thinkinginjava.string.example.chapter13_7.ex13_7_1;

import java.util.Scanner;

/**
 * @Author: monika
 * @Date: 2019/1/13 19:51
 * @Version: 1.0
 * @Description:
 * Scanner在默认情况下，是根据空白字符作为‘定界符’对输入进行分词的。
 * 可以使用Scanner#useDelimiter()方法使用正则表达式指定所需的‘定界符’进行分词。
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner = scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }
}
