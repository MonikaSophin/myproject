package com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:25
 * @Version: 1.0
 * @Description:
 */
class A {}

public class VarArgs {
    static void printArray(Object[] args) {
        for(Object obj : args)
            System.out.print(obj + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        printArray(new Object[]{
                new Integer(47), new Float(3.14), new Double(11.11)
        });
        printArray(new Object[]{"one", "two", "three" });
        printArray(new Object[]{new A(), new A(), new A()});
    }
}
/**
 * 47 3.14 11.11
 * one two three
 * com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1.A@4554617c com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1.A@74a14482 com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1.A@1540e19d
 */