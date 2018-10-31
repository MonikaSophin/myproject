package com.thinkinginjava.operators.example.chapter3_7.ex3_7_1;

public class EqualsMethod {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println("n1.equals(n2) : "+ (n1.equals(n2)));
    }
}
/**输出：
 * n1.equals(n2) : true
 */