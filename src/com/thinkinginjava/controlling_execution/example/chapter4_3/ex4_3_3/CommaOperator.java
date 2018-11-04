package com.thinkinginjava.controlling_execution.example.chapter4_3.ex4_3_3;

/**
 * @Author: monika
 * @Date: 2018/11/4 19:32
 * @Version: 1.0
 * @Description:
 */
public class CommaOperator {
    public static void main(String[] args) {
        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i = " + i + " j = " + j);
        }
    }
}
/**输出：
 * i = 1 j = 11
 * i = 2 j = 4
 * i = 3 j = 6
 * i = 4 j = 8
 *
 * 结论：无论在初始化还是在步进部分，语句都是顺序执行的。
 *     此外，初始化部分可以有任意数量的同一类型的定义。
 */
