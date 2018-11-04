package com.thinkinginjava.controlling_execution.exercise;

/**
 * @Author: monika
 * @Date: 2018/11/4 19:54
 * @Version: 1.0
 * @Description: page 67
 * 练习4：写一个程序，使用两个嵌套的for循环和取余操作符（%）来探测和打印
 * 素数（只能被其自身和1整除，而不能被其他数字整除的整数）。
 */
public class Ex04 {
    public static void main(String[] args) {
        int count =0;
        for (int i = 1; i <= 1000; i++) {
            int factors = 0;
            //排除自身，只有被1整除。
            for (int j = 1; j <= Math.sqrt(i); j++) {//j < (i+2)/2
                if ((i % j) == 0) factors++;
            }
            if (factors < 2) System.out.println(i + " is prime"+"   "+ ++count);
        }
    }
}
