package com.thinkinginjava.Initialize_clean.example.chapter5_8;

import com.thinkinginjava.util.Print;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:04
 * @Version: 1.0
 * @Description:
 */
public class ArrayNew {
    public static void main(String[] args) {
        int[] a;
        Random rand = new Random(47);
        a = new int[rand.nextInt(20)];
        Print.print("length of a = " + a.length);
        Print.print(Arrays.toString(a));
    }
}
/**输出：
 * length of a = 18
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 */