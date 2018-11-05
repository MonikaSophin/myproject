package com.thinkinginjava.controlling_execution.example.chapter4_6;

import com.thinkinginjava.controlling_execution.example.Range;

/**
 * @Author: monika
 * @Date: 2018/11/5 22:11
 * @Version: 1.0
 * @Description:    在任何迭代语句的主体部分，都可用break和continue控制循环的流程。
 *               其中，break用于强制退出循环，不执行循环的剩余语句。而continue则停止
 *               执行当前的迭代，然后退回循环起始处，开始下一次迭代。
 */
public class BreakAndContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 74) break;
            if (i % 9 != 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : Range.range(100)) {
            if (i == 74) break;
            if (i % 9 != 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        int i = 0;
        while (true) {
            i++;
            int j = i * 27;
            if (j == 1269) break;
            if (i % 10 != 0) continue;
            System.out.print(i + " ");
        }
    }
}
