package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.operators.example.chapter3_1.Print;

/**
 * page 52
 *
 * @Author: monika
 * @Date: 2018/11/4 15:38
 * @Version: 1.0
 * @Description: 练习13：编写一个方法，它以二进制形式显示char类型的值。使用多个不同的字符来展示它。
 */
public class Ex13 {
    public static void main(String[] args) {
        char char1 = 'a';
        Print.print("a = " + Integer.toBinaryString(char1));
        char1 = 'b';
        Print.print("b = " + Integer.toBinaryString(char1));
        char1 = 'c';
        Print.print("c = " + Integer.toBinaryString(char1));
        char1 += 1;
        Print.print("d = " + Integer.toBinaryString(char1));
        char d = 'd';
        Print.print("d = " + Integer.toBinaryString(d));

        char1 = 'A';
        Print.print("\nchar1 = " + Integer.toBinaryString(char1));
        for (int i = 1; i <= 25; i++) {
            char1+=1;
            Print.print("char1 = " + Integer.toBinaryString(char1));
        }
        char Z = 'Z';
        Print.print("Z = " + Integer.toBinaryString(Z));
    }
}
/**输出：
 * a = 1100001
 * b = 1100010
 * c = 1100011
 * d = 1100100   //d的二进制数值 -->c的二进制数值+1
 * d = 1100100
 *
 * char1 = 1000001
 * char1 = 1000010
 * char1 = 1000011
 * char1 = 1000100
 * char1 = 1000101
 * char1 = 1000110
 * char1 = 1000111
 * char1 = 1001000
 * char1 = 1001001
 * char1 = 1001010
 * char1 = 1001011
 * char1 = 1001100
 * char1 = 1001101
 * char1 = 1001110
 * char1 = 1001111
 * char1 = 1010000
 * char1 = 1010001
 * char1 = 1010010
 * char1 = 1010011
 * char1 = 1010100
 * char1 = 1010101
 * char1 = 1010110
 * char1 = 1010111
 * char1 = 1011000
 * char1 = 1011001
 * char1 = 1011010  //Z的二进制数值-->  Y的二进制数值+1
 * Z = 1011010
 */