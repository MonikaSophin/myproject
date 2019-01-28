package com.thinkinginjava.type_information.example.chapter14_2.ex14_2_2;

/**
 * @Author: monika
 * @Date: 2019/1/26 16:38
 * @Version: 1.0
 * @Description:
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
