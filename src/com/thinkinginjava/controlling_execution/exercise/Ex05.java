package com.thinkinginjava.controlling_execution.exercise;

/**
 * @Author: monika
 * @Date: 2018/11/4 20:20
 * @Version: 1.0
 * @Description: page 67
 * 练习5：重复第3章中的练习10，不要用Integer.toBinaryString()方法，
 * 而是用三元操作符和按位操作符来显示二进制的1和0,
 *
 * Integer.numberOfLeadingZeros(int a); -->
 * 返回指定{@code int a}值的二进制表示中最高位(“最左侧”)一位之前的零位数。
 * 如果指定的值在其二进制表示中没有一位，则返回32，换句话说，如果它等于零。
 */
public class Ex05 {
    static void binaryPrint (int q) {
        if(q == 0) System.out.print(0);
        else {
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;//将该二进制数移至32位的最前面。
            for(int p = 0; p < 32 - nlz; p++) {
                //最高位1的前面有没有0。没有0的话，该位是1;有0的话，该位是0（就是自身）。
                int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
                System.out.print(n);
                q <<= 1;//左移1位
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        int k = 0x100;
        int m = 0;
        System.out.println("Using Integer.toBinaryString():");
        System.out.println("i = " + Integer.toBinaryString(i));
        System.out.println("j = " + Integer.toBinaryString(j));
        System.out.println("k = " + Integer.toBinaryString(k));
        System.out.println("m = " + Integer.toBinaryString(m));
        System.out.println("i & j = " + (i & j) + " = " + Integer.toBinaryString(i & j));
        System.out.println("i | j = " + (i | j) + " = " + Integer.toBinaryString(i | j));
        System.out.println("i ^ j = " + (i ^ j) + " = " + Integer.toBinaryString(i ^ j));
        System.out.println("~i = " + Integer.toBinaryString(~i));
        System.out.println("~j = " + Integer.toBinaryString(~j));
        System.out.println("Using binaryPrint():");
        System.out.print("i = " + i + " = ");
        binaryPrint(i);
        System.out.print("j = " + j + " = ");
        binaryPrint(j);
        System.out.print("k = " + k + " = ");
        binaryPrint(k);
        System.out.print("m = " + m + " = ");
        binaryPrint(m);
        System.out.print("i & j = " + (i & j) + " = ");
        binaryPrint(i & j);
        System.out.print("i | j = " + (i | j) + " = ");
        binaryPrint(i | j);
        System.out.print("i ^ j = " + (i ^ j) + " = ");
        binaryPrint(i ^ j);
        System.out.print("~i = " + ~i + " = ");
        binaryPrint(~i);
        System.out.print("~j = " + ~j + " = ");
        binaryPrint(~j);
    }
}
