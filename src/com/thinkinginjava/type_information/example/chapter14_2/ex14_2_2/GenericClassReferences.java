package com.thinkinginjava.type_information.example.chapter14_2.ex14_2_2;

/**
 * @Author: monika
 * @Date: 2019/1/26 16:36
 * @Version: 1.0
 * @Description:
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class<Integer> intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        //! intClass = double.class;
    }
}
