package com.thinkinginjava.operators.example.chapter3_11;

import com.thinkinginjava.operators.example.chapter3_1.Print;

/**
 * @Author: monika
 * @Date: 2018/11/4 11:08
 * @Version: 1.0
 * @Description:
 */
public class URShift {
    public static void main(String[] args) {
        int i = -1;
        Print.print("int = "+Integer.toBinaryString(i));
        i >>>= 10;//i无符号右移10位，再赋值给i
        Print.print("int>>>10 = "+Integer.toBinaryString(i));
        long l = -1;
        Print.print("long = "+Long.toBinaryString(l));
        l >>>= 10;
        Print.print("long>>>10 = "+Long.toBinaryString(l));
        short s = -1;
        Print.print("short = "+Integer.toBinaryString(s));
        s >>>= 10;
        Print.print("short>>>10 = "+Integer.toBinaryString(s));
        byte b = -1;
        Print.print("byte = "+Integer.toBinaryString(b));
        b >>>= 10;
        Print.print("byte>>>10 = "+Integer.toBinaryString(b));
        b = -1;
        Print.print("byte = "+Integer.toBinaryString(b));
        Print.print("byte>>>10 = "+Integer.toBinaryString(b>>>10));
    }
}
/**输出：
 * int = 11111111111111111111111111111111
 * int>>>10 = 1111111111111111111111
 * long = 1111111111111111111111111111111111111111111111111111111111111111
 * long>>>10 = 111111111111111111111111111111111111111111111111111111
 * short = 11111111111111111111111111111111
 * short>>>10 = 11111111111111111111111111111111
 * byte = 11111111111111111111111111111111
 * byte>>>10 = 11111111111111111111111111111111
 * byte = 11111111111111111111111111111111
 * byte>>>10 = 1111111111111111111111
 */
