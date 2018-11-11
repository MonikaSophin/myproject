package com.thinkinginjava.Initialize_clean.exercise.chapter5_9;

/**
 * @Author: monika
 * @Date: 2018/11/11 18:08
 * @Version: 1.0
 * @Description: page 107
 * 练习21：创建一个enum，它包含纸币中最小面值的6种类型。
 * 通过values()循环并打印每一个值及其ordinal()。
 */

public class Ex21 {
    public enum Bills {
        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
    }

    public static void main(String[] args) {
        Bills[] values = Bills.values();
        for (Bills bill : values) {

            System.out.println(bill + "   " + bill.ordinal());
        }
    }
}
/**输出：
 * ONE   0
 * FIVE   1
 * TEN   2
 * TWENTY   3
 * FIFTY   4
 * HUNDRED   5
 */