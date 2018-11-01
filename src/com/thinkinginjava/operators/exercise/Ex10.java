package com.thinkinginjava.operators.exercise;

/**
 * @Author: monika
 * @Date: 2018/11/1 22:52
 * @Version: 1.0
 * @Description: 练习10：编写一个具有两个常量值的程序，一个具有交替的二进制位1和0.其中最低有有效位
 *               为0，另一个也具有交替的二进制位1和0，但是其最低有效位位1（提示：使用十六进制常量来
 *               表示是最简单的方法）。取这两个值，用按位操作符以所有可能的方式结合运算它们，然后用
 *               Integer.toBinaryString()显示。
 */
public class Ex10 {
    public static void main(String[] args) {
        int a = 1*32 + 0*16 + 1*8 + 0*4 +1*2 + 0*1;//101010
        int b = 0*32 + 1*16 + 0*8 + 1*4 +0*2 + 1*1;//010101
        System.out.println("a: " + Integer.toBinaryString(a));
        System.out.println("b: " + Integer.toBinaryString(b));
        System.out.println("按位操作符: 与&、或|、非~、异或^ ");
        System.out.println("a&b: " + Integer.toBinaryString(a & b));
        System.out.println("a|b: " + Integer.toBinaryString(a | b));
        System.out.println("a^b: " + Integer.toBinaryString(a ^ b));
        System.out.println("~a: " + Integer.toBinaryString(~ a));
        System.out.println("~b: " + Integer.toBinaryString(~ b));
    }
}
/**输出：
 * a: 101010
 * b: 10101
 * 按位操作符: 与&、或|、非~、异或^
 * a&b: 0
 * a|b: 111111
 * a^b: 111111
 * ~a: 11111111111111111111111111010101
 * ~b: 11111111111111111111111111101010
 */