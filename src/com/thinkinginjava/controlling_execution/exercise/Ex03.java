package com.thinkinginjava.controlling_execution.exercise;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/4 19:49
 * @Version: 1.0
 * @Description: page 67
 * 练习3： 修改练习2，把代码用一个while无限循环包括起来。然后运行它直至用键盘中断运行（通常是通过Ctrl+c）
 */
public class Ex03 {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        while (true) {
            int x = rand1.nextInt(100);
            int y = rand2.nextInt(100);
            if (x < y) {
                System.out.println(x + " < " + y);
            } else if (x > y) {
                System.out.println(x + " > " + y);
            } else {
                System.out.println(x + " = " + y);
            }
        }
    }
}
