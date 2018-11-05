package com.thinkinginjava.controlling_execution.exercise;

import com.thinkinginjava.controlling_execution.example.Print;

/**
 * @Author: monika
 * @Date: 2018/11/5 21:58
 * @Version: 1.0
 * @Description: page 69
 * 练习6：修改前两个程序中的两个test()方法，让它们接受两个额外的参数begin和end，
 * 这样在测试testval时将判断它是否在begin和end之间（包括begin和end）的范围内。
 */
public class Ex06 {
    static int test(int testval, int begin, int end) {
        if (testval>=begin && testval<=end)
            return +1;
        else if (testval<begin || testval>end)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Print.print(test(10, 5, 4));
        Print.print(test(5, 4, 10));
        Print.print(test(5, 5, 6));
        Print.print(test(10, 5, 7));
        Print.print(test(5, 5, 5));
    }
}
/**输出：
 * -1
 * 1
 * 1
 * -1
 * 1
 */