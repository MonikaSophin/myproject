package com.thinkinginjava.operators.example.chapter3_15;

/**
 * @Author: monika
 * @Date: 2018/11/4 17:40
 * @Version: 1.0
 * @Description:
 *       (1) java允许我们把任何基本数据类型转换成别的基本数据类型，
 *         但布尔类型除外，后者根本不允许进行任何类型的转换处理。
 *       (2) 要想执行类型转换，需要将希望得到的数据类型置于圆括号内，
 *         放在要进行类型转换的值的左边。
 *       (3) 扩展转化：小转大 无需显式的加上类型转换操作符()
 *           窄化转化：大转小 需要显式的加上类型转换操作符()
 */
public class Casting {
    public static void main(String[] args) {
        int i = 200;
        long lng = (long)i; //扩展转化：小转大 无需显式的加上类型转换操作符()
        lng = i; // "Widening," so cast not really required
        long lng2 = (long)200;
        lng2 = 200;
        // A "narrowing conversion":
        i = (int)lng2; // Cast required 窄化转化：大转小 需要显式的加上类型转换操作符()
    }
}
