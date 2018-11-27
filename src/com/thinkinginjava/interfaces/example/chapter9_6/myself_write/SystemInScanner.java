package com.thinkinginjava.interfaces.example.chapter9_6.myself_write;

import java.util.Scanner;

/**
 * @Author: monika
 * @Date: 2018/11/26 22:09
 * @Version: 1.0
 * @Description:   自己写的，不是书上的。
 *  System.in --> 系统输入的字符流
 */
public class SystemInScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
