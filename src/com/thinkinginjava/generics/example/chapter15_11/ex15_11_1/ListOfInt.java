package com.thinkinginjava.generics.example.chapter15_11.ex15_11_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/15
 * @description:
 */
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            li.add(i);
        for (int i : li)
            System.out.print(i + " ");
    }
}
/**output:
 * 0 1 2 3 4
 */