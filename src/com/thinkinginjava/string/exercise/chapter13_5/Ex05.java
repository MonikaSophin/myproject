package com.thinkinginjava.string.exercise.chapter13_5;

import com.thinkinginjava.string.example.chapter13_5.ex13_5_5.Conversion;
import java.math.BigInteger;
import java.util.Formatter;

/**
 * @Author: monika
 * @Date: 2019/1/1 14:34
 * @Version: 1.0
 * @Description: page 294
 * 练习05:针对前边表格中的各种基本转化类型，请利用所有可能的格式修饰符，写出
 * 一个尽可能复杂的格式化表达式。
 */
public class Ex05 {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("char u = \'a\'");
        f.format("%-2s%-2S%-2c%-2C%-5b%-5B%-3h%-3H%%\n", u,u,u,u,u,u,u,u);

        int v = 121;
        System.out.println("int v = 121");
        f.format("%-4s%-4S%-4d%-4c%-4C%-5b%-5B%-4x%-4X%-4h%-4H%%\n", v,v,v,v,v,v,v,v,v,v,v);

        BigInteger w = new BigInteger("50000000000000");
        System.out.println("BigInteger w = 50000000000000");
        f.format("%-15s%-15S%-5b%-5B%-15x%-15X%-5h%-5H%%\n", w,w,w,w,w,w,w,w);

        double x = 179.543;
        System.out.println("double x = 179.543");
        f.format("%-8s%-8S%-5b%-5B%-15f%-15e%-15E%-12h%-12H%%\n", x,x,x,x,x,x,x,x,x);

        Conversion y = new Conversion();
        System.out.println("Conversion y = new Conversion()");
        f.format("%-20s%-20S%-5b%-5B%-10h%-10H%%\n", y,y,y,y,y,y);

        boolean z = false;
        System.out.println("boolean z = false");
        f.format("%-7s%-7S%-7b%-7B%-7h%-7H%%\n", z,z,z,z,z,z);
    }
}
/**output:
 * char u = 'a'
 * a A a A true TRUE 61 61 %
 * int v = 121
 * 121 121 121 y   Y   true TRUE 79  79  79  79  %
 * BigInteger w = 50000000000000
 * 50000000000000 50000000000000 true TRUE 2d79883d2000   2D79883D2000   8842a1a78842A1A7%
 * double x = 179.543
 * 179.543 179.543 true TRUE 179.543000     1.795430e+02   1.795430E+02   1ef462c     1EF462C     %
 * Conversion y = new Conversion()
 * com.thinkinginjava.string.example.chapter13_5.ex13_5_5.Conversion@12a3a380COM.THINKINGINJAVA.STRING.EXAMPLE.CHAPTER13_5.EX13_5_5.CONVERSION@12A3A380true TRUE 12a3a380  12A3A380  %
 * boolean z = false
 * false  FALSE  false  FALSE  4d5    4D5    %
 */