package com.thinkinginjava.operators.example.chapter3_8;

import com.thinkinginjava.util.Print;

import java.util.Random;

public class Bool {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        Print.print("i: " + i);
        Print.print("j: " + j);
        Print.print("i > j is " +(i > j));
        Print.print("i < j is " +(i < j));
        Print.print("i >= j is " +(i >= j));
        Print.print("i <= j is " +(i <= j));
        Print.print("i == j is " +(i == j));
        Print.print("i != j is " +(i != j));
        //! Print.print("i && j is " +(i && j));
        //! Print.print("i || j is " +(i || j));
        Print.print("(i < 10)&&(j < 10) is " +((i < 10)&&(j < 10)));
        Print.print("(i < 10)||(j < 10) is " +((i < 10)||(j < 10)));
    }
}
/**输出：
 * i: 58
 * j: 55
 * i > j is true
 * i < j is false
 * i >= j is true
 * i <= j is false
 * i == j is false
 * i != j is true
 * (i < 10)&&(j < 10) is false
 * (i < 10)||(j < 10) is false
 *
 * 结论：
 * “与”（&&、&）、“或”(||、|)、“非”(!)操作只可应用于布尔值。 //! 注释防止编译错误。
 */