package com.thinkinginjava.Initialize_clean.exercise.chapter5_8;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:45
 * @Version: 1.0
 * @Description: page 105
 * 练习19：写一个类，它接受一个可变参数的String数组，验证你可以向该方法传递一个
 * 用逗号分隔的String列表，或是一个String[]。
 */
public class Ex19 {
    static void f(String... args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f("a", "b", "c");
        String [] s = new String[]{"d","c", "b", "a"};
        f(s);
    }
}
/**输出：
 * a b c
 * c b a
 *
 */