package com.thinkinginjava.operators.example.chapter3_6;

import com.thinkinginjava.util.Print;

public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        Print.print("i : " + i);//i=1;
        Print.print("++i : " + ++i);//i=2;
        Print.print("i : " + i);//i=2;
        Print.print("i++ : " + i++);//i=2;-->3
        Print.print("i : " + i);//i=3;
        Print.print("--i : " + --i);//i=2;
        Print.print("i : " + i);//i=2;
        Print.print("i-- : " + i--);//i=2;-->1
        Print.print("i : " + i);//i=1;
    }
}
/**输出：
 * i : 1
 * ++i : 2
 * i : 2
 * i++ : 2
 * i : 3
 * --i : 2
 * i : 2
 * i-- : 2
 * i : 1
 *
 * 结论：
 *   ++、--在前，先运算再赋值。
 *   ++、--在后，先赋值再运算。
 */