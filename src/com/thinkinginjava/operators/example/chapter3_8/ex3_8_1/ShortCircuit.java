package com.thinkinginjava.operators.example.chapter3_8.ex3_8_1;

import com.thinkinginjava.util.Print;

public class ShortCircuit {
    static boolean test1(int val1){
        Print.print("test1("+ val1 +")");
        Print.print("result: "+ (val1 < 1));
        return val1 < 1;
    }
    static boolean test2(int val2){
        Print.print("test2("+ val2 +")");
        Print.print("result: "+ (val2 < 2));
        return val2 < 2;
    }
    static boolean test3(int val3){
        Print.print("test3("+ val3 +")");
        Print.print("result: "+ (val3 < 3));
        return val3 < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(2) && test3(3);
        Print.print("expression is " + b);
    }
}
/**结果：
 * test1(0)
 * result: true
 * test2(2)
 * result: false
 * expression is false
 *
 * 结论：当使用逻辑操作符时，我们会遇到一种“短路”现象。即一旦能够明确无误地确定整个表达式的值时，
 *   就不再计算表达式剩下的部分了。因此，整个逻辑表达式靠后的部分有可能不会被运算。
 */