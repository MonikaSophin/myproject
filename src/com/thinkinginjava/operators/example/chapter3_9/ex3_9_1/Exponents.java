package com.thinkinginjava.operators.example.chapter3_9.ex3_9_1;

public class Exponents {
    public static void main(String[] args) {
        float expFloat = 1.39e-43F;
        System.out.println(expFloat);
        double expDouble1 = 47E47D;
        double expDouble2 = 47e47;
        System.out.println(expDouble1);
        System.out.println(expDouble2);

        System.out.println("自然对数的基数e: " + Math.E);
    }
}
/**输出：
 * 1.39E-43
 * 4.7E48
 * 4.7E48
 * 自然对数的基数e: 2.718281828459045
 *
 * 结论：在科学和工程领域中，e代表自然对数的基数。（java中的Math.E给出了更精确的double型的值。）
 *   而表达式中的e（或E）则表示为“10的幂次”。
 */