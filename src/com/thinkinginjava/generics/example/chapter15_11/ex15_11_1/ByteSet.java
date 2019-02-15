package com.thinkinginjava.generics.example.chapter15_11.ex15_11_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/15
 * @description:
 */
public class ByteSet {
    Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));
    Set<Integer> mySet2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    // 但是不能做这个：
    // Set<Byte> mySet2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
}
