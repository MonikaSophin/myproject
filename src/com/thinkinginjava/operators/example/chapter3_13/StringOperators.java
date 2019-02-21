package com.thinkinginjava.operators.example.chapter3_13;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/4 17:30
 * @Version: 1.0
 * @Description:
 */
public class StringOperators {
    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = "x, y, z ";
        Print.print(s + x + y + z);
        Print.print(x + " " + s); // Converts x to a String
        s += "(summed) = "; // Concatenation operator
        Print.print(s + (x + y + z));
        Print.print("" + x); // Shorthand for Integer.toString()
    }
}
/**输出：
 * x, y, z 012
 * 0 x, y, z
 * x, y, z (summed) = 3
 * 0
 */
