package com.thinkinginjava.operators.example.chapter3_3;

public class Precedence {
    public static void main(String[] args) {
        int x =1,y = 2,z = 3;
        int a = x + y - 2/2 + z;
        int b = x + (y - 2)/(2 + z);
        System.out.println("a = "+ a + " b = " + b);
    }
}
/**输出：
 * a = 5 b = 1
 */