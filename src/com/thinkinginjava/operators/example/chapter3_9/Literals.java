package com.thinkinginjava.operators.example.chapter3_9;

import com.thinkinginjava.operators.example.chapter3_1.Print;

public class Literals {
    public static void main(String[] args) {
        int int1 = 0x2f;
        Print.print("int1: " + Integer.toBinaryString(int1));//二进制
        int int2 = 0X2F;
        Print.print("int2: " + Integer.toBinaryString(int2));
        int int3 = 0177;
        Print.print("int3: " + Integer.toBinaryString(int3));
        char char1 = 0xffff;
        Print.print("char1: " + Integer.toBinaryString(char1));
        byte byte1 = 0X7F;
        Print.print("byte1: " + Integer.toBinaryString(byte1));
        short short1 = 0x7fff;
        Print.print("short1: " + Integer.toBinaryString(short1));
        long long1 = 200L;
        Print.print("long1: " + Long.toBinaryString(long1));
        long long2 = 200l;
        Print.print("long2: " + Long.toBinaryString(long2));
        long long3 = 200;
        Print.print("long3: " + Long.toBinaryString(long3));
        float float1 = 1;
        Print.print("float1: " + Float.toHexString(float1));//十六进制
        float float2 = 1F;
        Print.print("float2: " + Float.toHexString(float2));
        float float3 = 1f;
        Print.print("float3: " + Float.toHexString(float3));
        double double1 = 1d;
        Print.print("double1: " + Double.toHexString(double1));
        double double2 = 1D;
        Print.print("double2: " + Double.toHexString(double2));
    }
}
/**输出:
 * int1: 101111
 * int2: 101111
 * int3: 1111111
 * char1: 1111111111111111
 * byte1: 1111111
 * short1: 111111111111111
 * long1: 11001000
 * long2: 11001000
 * long3: 11001000
 * float1: 0x1.0p0
 * float2: 0x1.0p0
 * float3: 0x1.0p0
 * double1: 0x1.0p0
 * double2: 0x1.0p0
 *
 * 结论：直接常量后面的后缀字符标志了它的类型。若为大写（或小写）的L，代表long（但是，
 *  使用小写字母l容易造成混淆，因为它看起来很像数字1）。大写（或小写）字母F，代表float；
 *  大写（或小写）字母D，则代表double。
 *     十六进制数适用于所有整数数据类型，以前缀0x（或0X），后面跟0~9或小写（或大写）的
 *  a~f来表示。
 *     八进制数由前缀0以及后续的0~7的数字来表示。
 *     在java、C、C++中，二进制数没有直接常量表示方法，
 *
 *     在page 23,有基本类型数据所占存储空间的大小范围。
 */