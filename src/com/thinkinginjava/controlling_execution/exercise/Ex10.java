package com.thinkinginjava.controlling_execution.exercise;

/**
 * @Author: monika
 * @Date: 2018/11/6 22:59
 * @Version: 1.0
 * @Description: page 75
 * 练习10：吸血鬼数字是指 位数为偶数的数字，可以由一对数字相乘而得到，而这对数字
 * 各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序。以两个0结尾的
 * 数字是不允许的，例如：下列数字都是“吸血鬼”数字：
 * 1260=21*60
 * 1827=21*87
 * 2187=27*81
 * 写一个程序，找出4位数的所有“吸血鬼”数字（Dan Forhan推荐）
 */
public class Ex10 {
    static int a(int i) {
        return i/1000;
    }
    static int b(int i) {
        return (i%1000)/100;
    }
    static int c(int i) {
        return ((i%1000)%100)/10;
    }
    static int d(int i) {
        return ((i%1000)%100)%10;
    }
    static int com(int i, int j) {
        return (i * 10) + j;
    }
    static void productTest (int i, int m, int n) {
        if(m * n == i) System.out.println(i + " = " + m + " * " + n);
    }
    public static void main(String[] args) {
        for(int i = 1001; i < 9999; i++) {
            productTest(i, com(a(i), b(i)), com(c(i), d(i)));
            productTest(i, com(a(i), b(i)), com(d(i), c(i)));
            productTest(i, com(a(i), c(i)), com(b(i), d(i)));
            productTest(i, com(a(i), c(i)), com(d(i), b(i)));
            productTest(i, com(a(i), d(i)), com(b(i), c(i)));
            productTest(i, com(a(i), d(i)), com(c(i), b(i)));
            productTest(i, com(b(i), a(i)), com(c(i), d(i)));
            productTest(i, com(b(i), a(i)), com(d(i), c(i)));
            productTest(i, com(b(i), c(i)), com(d(i), a(i)));
            productTest(i, com(b(i), d(i)), com(c(i), a(i)));
            productTest(i, com(c(i), a(i)), com(d(i), b(i)));
            productTest(i, com(c(i), b(i)), com(d(i), a(i)));
        }
    }
}
