package com.thinkinginjava.controlling_execution.exercise;

/**
 * @Author: monika
 * @Date: 2018/11/6 22:41
 * @Version: 1.0
 * @Description: page 75
 * 练习09：一个斐波那契数列是由数字1、1、2、3、5、8、13、21、34等等组成的，
 * 其中每一个数字（从第三个数字起）都是前两个数字的和。创建一个方法，接受一个
 * 整形参数，并显示从第一个元素开始总共由该参数指定的个数所构成的所有斐波那契数字。
 * 例如：如果运行java Fibonacci5(其中Fibonacci是类名)，那么输出就应该是1、1、2、3、5。
 */
public class Ex09 {
    int fib(int n) {
        if (n < 2) return 1;
        return (fib(n - 2) + fib(n - 1));
    }

    public static void main(String[] args) {
        Ex09 f = new Ex09();
        int k = Integer.parseInt(args[0]);
        System.out.println("First " + k + " Fibonacci number(s): ");
        for (int i = 0; i < k; i++)
            System.out.println(f.fib(i));
    }
}
