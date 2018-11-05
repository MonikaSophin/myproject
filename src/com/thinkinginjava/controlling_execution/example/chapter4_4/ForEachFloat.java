package com.thinkinginjava.controlling_execution.example.chapter4_4;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/5 21:45
 * @Version: 1.0
 * @Description:
 */
public class ForEachFloat {
    public static void main(String[] args) {
        Random rand = new Random(47);
        float f[] = new float[10];
        for (int i = 0; i < 10; i++)
            f[i] = rand.nextFloat();
        for (float x : f)
            System.out.println(x);
    }
}
/**输出：
 * 0.72711575
 * 0.39982635
 * 0.5309454
 * 0.0534122
 * 0.16020656
 * 0.57799757
 * 0.18847865
 * 0.4170137
 * 0.51660204
 * 0.73734957
 */