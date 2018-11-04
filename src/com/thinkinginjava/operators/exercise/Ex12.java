package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.operators.example.chapter3_1.Print;

/**page 12
 * @Author: monika
 * @Date: 2018/11/4 15:20
 * @Version: 1.0
 * @Description: 练习12：
 */
public class Ex12 {
    public static void main(String[] args) {
        int int1 = -1;//2e32 - 1
        Print.print("int1 = "+Integer.toBinaryString(int1));

        Print.print("先左移10位");
        int1<<=10;
        Print.print("int1 = "+Integer.toBinaryString(int1));

        Print.print("再每次无符号右移1位");
        for (int i = 1; i <= 32; i++) {
            int1>>>=1;
            Print.print("int1 = "+Integer.toBinaryString(int1));
        }
        int1>>>=1;
        Print.print("int1 = "+Integer.toBinaryString(int1));
    }
}
/**输出：
 * int1 = 11111111111111111111111111111111
 * 先左移10位
 * int1 = 11111111111111111111110000000000
 * 再每次无符号右移1位
 * int1 = 1111111111111111111111000000000
 * int1 = 111111111111111111111100000000
 * int1 = 11111111111111111111110000000
 * int1 = 1111111111111111111111000000
 * int1 = 111111111111111111111100000
 * int1 = 11111111111111111111110000
 * int1 = 1111111111111111111111000
 * int1 = 111111111111111111111100
 * int1 = 11111111111111111111110
 * int1 = 1111111111111111111111
 * int1 = 111111111111111111111
 * int1 = 11111111111111111111
 * int1 = 1111111111111111111
 * int1 = 111111111111111111
 * int1 = 11111111111111111
 * int1 = 1111111111111111
 * int1 = 111111111111111
 * int1 = 11111111111111
 * int1 = 1111111111111
 * int1 = 111111111111
 * int1 = 11111111111
 * int1 = 1111111111
 * int1 = 111111111
 * int1 = 11111111
 * int1 = 1111111
 * int1 = 111111
 * int1 = 11111
 * int1 = 1111
 * int1 = 111
 * int1 = 11
 * int1 = 1
 * int1 = 0
 * int1 = 0      无符号右移，移出全部32位之后，再右移也是往高位补0，所以会显示0
 *
 */
