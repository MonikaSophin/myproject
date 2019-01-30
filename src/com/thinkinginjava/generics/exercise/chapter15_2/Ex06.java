package com.thinkinginjava.generics.exercise.chapter15_2;

import com.thinkinginjava.generics.example.chapter15_2.ex15_2_3.RandomList;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description: page 358
 * 练习06:使用RandomList来处理两种额外的不同类型的元素，要区别于main()中以及用过的类型。
 */
public class Ex06 {
    public static void main(String[] args) {
        RandomList<Integer> rs = new RandomList<>();
        for (Integer s : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})
            rs.add(s);
        for (int i = 0; i < 11; i++)
            System.out.print(rs.select() + " ");
    }
}
/**output:
 * 2 8 4 2 4 2 1 5 0 4 3
 */