package com.thinkinginjava.controlling_execution.exercise;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/5 22:22
 * @Version: 1.0
 * @Description: page 70
 * 练习7：修改本章的练习1，通过使用break关键词，使得程序在打印到99时退出。
 * 然后尝试使用return来达到相同的目的。
 */
public class Ex07 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
            if (i == 99)
                break;
        }

        System.out.println();
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
            if (i == 99)
                return;
        }


    }
}
