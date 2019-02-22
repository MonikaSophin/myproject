package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_5;

import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.RandomGenerator;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description:
 * TreeSet:保持排序顺序。
 * LinkedHashSet:保持插入顺序。
 */
public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println(String.format("Index: %s \n %s", index, sa[index]));

        // 这种用法也可以。
        // Arrays.sort(sa, String::compareToIgnoreCase);
        // System.out.println(Arrays.toString(sa));
        // int index = Arrays.binarySearch(sa, sa[10], String::compareToIgnoreCase);
        // System.out.println(String.format("Index: %s \n %s", index, sa[index]));
    }
}
/**output:
 * [bkIna, cQrGs, cXZJo, dLsmw, eGZMm, EqUCB, gwsqP, hKcxr, HLGEa, HqXum, HxxHv, JMRoE, JmzMs, Mesbt, MNvqe, nyGcF, ogoYW, OneOE, OWZnT, RFJQA, rUkZP, sgqia, slJrL, suEcU, uTpnX, vpfFv, WHkjU, xxEAJ, YNzbr, zDyCy]
 * Index: 10
 *  HxxHv
 */