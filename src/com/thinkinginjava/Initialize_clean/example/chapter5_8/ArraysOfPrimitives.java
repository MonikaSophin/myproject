package com.thinkinginjava.Initialize_clean.example.chapter5_8;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:00
 * @Version: 1.0
 * @Description:   所有数组（无论它们的元素是对象还是基本类型）都有一个固有成员，可以通过它获知数
 *              组内包含了多少个元素，但不能对其修改。这个成员就是length。
 *              下标为[0,length-1].
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[] a2;
        a2 = a1;
        for(int i = 0; i < a2.length; i++)
            a2[i] = a2[i] + 1;
        for(int i = 0; i < a1.length; i++)
            Print.print("a1[" + i + "] = " + a1[i]);
    }
}
/**输出：
 * a1[0] = 2
 * a1[1] = 3
 * a1[2] = 4
 * a1[3] = 5
 * a1[4] = 6
 */