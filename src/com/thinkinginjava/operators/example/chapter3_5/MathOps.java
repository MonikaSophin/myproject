package com.thinkinginjava.operators.example.chapter3_5;

import com.thinkinginjava.operators.example.chapter3_1.Print;

import java.util.Random;

public class MathOps {
    public static void main(String[] args) {
        /**
         *  Random对象在创建时如果构造函数不传入任何参数，那么会将当亲系统的纳秒时间作为种子，
         *  {@link Random#Random()},那么程序每一次执行都会产生不同的输出。
         * 当Random对象在创建时，传入种子（用于随机数生成器的初始化值），
         * 随机数生成器对于特定的种子值总是产生相同的随机数序列，就能在每一次执行程序时生成相同的随机数。
         */
        Random rand = new Random(47);
        int i,j,k;
        j = rand.nextInt(100) + 1;
        Print.print("j: " + j);
        k = rand.nextInt(100) + 1;
        Print.print("k: " + k);
        i = j + k;
        Print.print("j + k: " + i);
        i = j - k;
        Print.print("j - k: " + i);
        i = j * k;
        Print.print("j * k: " + i);
        i = j / k;
        Print.print("j / k: " + i);
        j %= k;
        Print.print("j %= k: " + j);

        float u ,v ,w;
        v = rand.nextFloat();
        Print.print("v: " + v);
        w = rand.nextFloat();
        Print.print("w: " + w);
        u = v + w;
        Print.print("v + w: " + u);
        u = v - w;
        Print.print("v - w: " + u);
        u = v * w;
        Print.print("v * w: " + u);
        u = v / w;
        Print.print("v / w: " + u);
        u += v;
        Print.print("u += v: " + u);
        u -= v;
        Print.print("u -= v: " + u);
        u *= v;
        Print.print("u *= v: " + u);
        u /= v;
        Print.print("u /= v: " + u);
    }
}
