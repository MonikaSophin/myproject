package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.operators.example.chapter3_1.Print;

class Flower{
    float f;
}

public class Ex03 {
    static void change(Flower y){
        y.f = 10.0F;
    }
    public static void main(String[] args) {
        Flower x = new Flower();
        x.f = 8.0F;
        Print.print("1: x.f = " + x.f);
        /**
         * 将引用x赋值给引用y(也就是x、y包含相同的引用)。
         * 则引用x、y都是指向同一个对象，所以操作引用y实际就是操作引用x。
         */
        change(x);
        Print.print("2: x.f = " + x.f);
    }
}
/**输出：
 * 1: x.f = 8.0
 * 2: x.f = 10.0
 */