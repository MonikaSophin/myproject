package com.thinkinginjava.holding_objects.exercise.chapter11_2;

import java.util.Collection;
import java.util.HashSet;

/**
 * @Author: monika
 * @Date: 2018/12/11 22:11
 * @Version: 1.0
 * @Description: page 220
 * 练习02：修改SimpleCollection,java,使用Set来表示c。
 */
public class Ex02 {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for(Integer i : c)
            System.out.print(i + ", ");
    }
}
/**输出：
 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
 */