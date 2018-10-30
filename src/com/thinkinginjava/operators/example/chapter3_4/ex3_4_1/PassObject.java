package com.thinkinginjava.operators.example.chapter3_4.ex3_4_1;

import com.thinkinginjava.operators.example.chapter3_1.Print;

class Letter{
    char c;
}

public class PassObject {
    static void f(Letter y){
        y.c = 'z';
    }
    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        Print.print("1: x.c = "+x.c);
        /**
         * 将引用x赋值给引用y(也就是x、y包含相同的引用)。
         * 则引用x、y都是指向同一个对象，所以操作引用y实际就是操作引用x。
         */
        f(x);
        Print.print("2: x.c = "+x.c);
    }
}
/**输出：
 * 1: x.c = a
 * 2: x.c = z
 */