package com.thinkinginjava.Initialize_clean.exercise.chapter5_8;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:12
 * @Version: 1.0
 * @Description: page 101
 * 练习18：通过创建对象赋值给引用数组，从而完成前一个练习。
 */
class InitTest2 {
    InitTest2(String s) {
        System.out.println("InitTest()");
        System.out.println(s);
    }
}

public class Ex18 {
    public static void main(String[] args) {
        InitTest2[] it = new InitTest2[5];
        for (int i = 0; i < it.length; i++)
            it[i] = new InitTest2(Integer.toString(i));
    }
}
/**输出：
 * InitTest()
 * 0
 * InitTest()
 * 1
 * InitTest()
 * 2
 * InitTest()
 * 3
 * InitTest()
 * 4
 */