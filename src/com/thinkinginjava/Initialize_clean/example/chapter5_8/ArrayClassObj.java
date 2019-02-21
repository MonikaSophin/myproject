package com.thinkinginjava.Initialize_clean.example.chapter5_8;

import com.thinkinginjava.util.Print;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:05
 * @Version: 1.0
 * @Description:
 */
public class ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
        Print.print("length of a = " + a.length);
        for(int i = 0; i < a.length; i++)
            a[i] = rand.nextInt(500); // Autoboxing
        Print.print(Arrays.toString(a));
    }
}
/**输出：
 * length of a = 18
 * [55, 193, 361, 461, 429, 368, 200, 22, 207, 288, 128, 51, 89, 309, 278, 498, 361, 20]
 */