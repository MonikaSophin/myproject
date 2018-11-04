package com.thinkinginjava.controlling_execution.example.chapter4_2;

/**
 * @Author: monika
 * @Date: 2018/11/4 19:18
 * @Version: 1.0
 * @Description:
 */
public class IfElse {
    static int result = 0;
    static void test(int testval, int target) {
        if (testval > target)
            result = +1;
        else if (testval < target)
            result = -1;
        else
            result = 0; // Match
    }
    public static void main(String[] args) {
        test(10, 5);
        System.out.println(result);
        test(5, 10);
        System.out.println(result);
        test(5, 5);
        System.out.println(result);
    }
}
/**输出：
 * 1
 * -1
 * 0
 */