package com.thinkinginjava.generics.example.chapter15_4;

/**
 * @Author: monika
 * @Date: 2019/2/2 21:39
 * @Version: 1.0
 * @Description:
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods methods = new GenericMethods();
        methods.f(" ");
        methods.f(1);
        methods.f(1.0);
        methods.f(1.0F);
        methods.f('c');
        methods.f(methods);
    }
}
/**output:
 * java.lang.String
 * java.lang.Integer
 * java.lang.Double
 * java.lang.Float
 * java.lang.Character
 * com.thinkinginjava.generics.example.chapter15_4.GenericMethods
 */