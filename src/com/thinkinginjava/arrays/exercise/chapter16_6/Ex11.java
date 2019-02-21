package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.util.CountingGenerator;
import com.thinkinginjava.util.Generated;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习11：展示自动包装机制不能应用于数组。
 */
public class Ex11 {
    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        int[] b = new int[10];
        // 编译错误：不兼容类型
        //! b = a;
        // 编译错误：不兼容类型
        //! a = b;
    }
}
/**output:
 * [0, 1, 2, 3, 4]
 */