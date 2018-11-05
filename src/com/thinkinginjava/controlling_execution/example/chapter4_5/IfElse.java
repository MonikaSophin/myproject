package com.thinkinginjava.controlling_execution.example.chapter4_5;

import com.thinkinginjava.controlling_execution.example.Print;

/**
 * @Author: monika
 * @Date: 2018/11/5 21:55
 * @Version: 1.0
 * @Description:    在java中有很多个关键词表示无条件分支，他们只是表示这个分支无需任何测试即可发生。
 *               这些关键词包括return、break、continue等。
 *                  return关键词有两方面的用途：一方面指定一个方法返回什么值（假设它没有void返回值），
 *               另一方面它会导致当前的方法退出，并返回那个值。
 */
public class IfElse {
    static int test(int testval, int target) {
        if (testval > target)
            return +1;
        else if (testval < target)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Print.print(test(10, 5));
        Print.print(test(5, 10));
        Print.print(test(5, 5));
    }
}
/**输出：
 * 1
 * -1
 * 0
 */