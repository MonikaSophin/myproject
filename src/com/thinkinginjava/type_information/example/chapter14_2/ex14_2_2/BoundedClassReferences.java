package com.thinkinginjava.type_information.example.chapter14_2.ex14_2_2;

/**
 * @Author: monika
 * @Date: 2019/1/26 16:40
 * @Version: 1.0
 * @Description:
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
