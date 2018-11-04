package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.operators.example.chapter3_1.Print;

/**page 52
 * @Author: monika
 * @Date: 2018/11/4 14:15
 * @Version: 1.0
 * @Description: 练习11：以一个最高有效位位1的二进制数字开始（提示：使用十六进制常量），
 *                有符号右移操作符对其进行右移，直至所有的二进制位都被移出为止，每移一位
 *                都要使用Integer.toBinaryString()显示结果。
 *
 *                无符号右移，无论正负数，右移时高位补0
 */
public class Ex11 {
    public static void main(String[] args) {
        Print.print("每次无符号右移1位");
        int int1 = -0xffff;//-2e16 + 1
        Print.print("int1 = "+Integer.toBinaryString(int1));
        for (int i = 1; i <= 32 ; i++) {
            int1>>>=1;
            Print.print("int1 = "+Integer.toBinaryString(int1));
        }
        int1>>>=1;
        Print.print("int1 = "+Integer.toBinaryString(int1));

        Print.print("\n每次无符号右移40位--> 也就是移8位(40-32)");
        int int2 = -0xffff;
        Print.print("int2 = "+Integer.toBinaryString(int2));
        for (int i = 1; i <=4 ; i++) {
            int2>>>=40;
            Print.print("int2 = "+Integer.toBinaryString(int2));
        }
        int2>>>=40;
        Print.print("int2 = "+Integer.toBinaryString(int2));
    }
}
/**输出：
 * 每次无符号右移1位
 * int1 = 11111111111111110000000000000001
 * int1 = 1111111111111111000000000000000
 * int1 = 111111111111111100000000000000
 * int1 = 11111111111111110000000000000
 * int1 = 1111111111111111000000000000
 * int1 = 111111111111111100000000000
 * int1 = 11111111111111110000000000
 * int1 = 1111111111111111000000000
 * int1 = 111111111111111100000000
 * int1 = 11111111111111110000000
 * int1 = 1111111111111111000000
 * int1 = 111111111111111100000
 * int1 = 11111111111111110000
 * int1 = 1111111111111111000
 * int1 = 111111111111111100
 * int1 = 11111111111111110
 * int1 = 1111111111111111
 * int1 = 111111111111111
 * int1 = 11111111111111
 * int1 = 1111111111111
 * int1 = 111111111111
 * int1 = 11111111111
 * int1 = 1111111111
 * int1 = 111111111
 * int1 = 11111111
 * int1 = 1111111
 * int1 = 111111
 * int1 = 11111
 * int1 = 1111
 * int1 = 111
 * int1 = 11
 * int1 = 1
 * int1 = 0
 * int1 = 0      无符号右移，移出全部32位之后，再右移也是往高位补0，所以会显示0
 *
 * 每次无符号右移40位--> 也就是移8位(40-32)
 * int2 = 11111111111111110000000000000001
 * int2 = 111111111111111100000000
 * int2 = 1111111111111111
 * int2 = 11111111
 * int2 = 0
 * int2 = 0      无符号右移，移出全部32位之后，再右移也是往高位补0，所以会显示0
 *
 */