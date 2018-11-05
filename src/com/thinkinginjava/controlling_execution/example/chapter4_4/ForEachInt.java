package com.thinkinginjava.controlling_execution.example.chapter4_4;

import com.thinkinginjava.controlling_execution.example.Print;
import com.thinkinginjava.controlling_execution.example.Range;

/**
 * @Author: monika
 * @Date: 2018/11/5 21:50
 * @Version: 1.0
 * @Description:
 */
public class ForEachInt {
    public static void main(String[] args) {
        for (int i : Range.range(10)) // 0..9
            Print.printnb(i + " ");
        Print.print();
        for (int i : Range.range(5, 10)) // 5..9
            Print.printnb(i + " ");
        Print.print();
        for (int i : Range.range(5, 20, 3)) // 5..20 step 3
            Print.printnb(i + " ");
        Print.print();
    }
}
/**输出：
 * 0 1 2 3 4 5 6 7 8 9
 * 5 6 7 8 9
 * 5 8 11 14 17
 */