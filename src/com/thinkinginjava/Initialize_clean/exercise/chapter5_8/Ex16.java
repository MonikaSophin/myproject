package com.thinkinginjava.Initialize_clean.exercise.chapter5_8;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:09
 * @Version: 1.0
 * @Description: page 101
 * 练习16：创建一个String对象数据，并为每一个元素都赋值一个String。用for循环来打印该数组。
 */
public class Ex16 {
    public static void main(String[] args) {
        String[] s = { "one", "two", "three", };
        for(int i = 0; i < s.length; i++)
            System.out.println("s[" + i + "] = " + s[i]);
    }
}
/**输出：
 * s[0] = one
 * s[1] = two
 * s[2] = three
 */