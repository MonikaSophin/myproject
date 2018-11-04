package com.thinkinginjava.controlling_execution.exercise;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/4 19:41
 * @Version: 1.0
 * @Description: page 66
 * 练习2：写一个程序，产生25个int类型的随机数。对于每一个随机值，
 *  使用if-else语句来将其分类为大于、小于，或等于紧随它而生成的值。
 */
public class Ex02 {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        for(int i = 0; i < 25; i++) {
            int x = rand1.nextInt(10);
            int y = rand2.nextInt(10);
            if(x < y) System.out.println(x + " < " + y);
            else if(x > y) System.out.println(x + " > " + y);
            else System.out.println(x + " = " + y);
        }
    }
}
