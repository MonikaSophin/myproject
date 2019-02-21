package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.util.Print;

/** page 48
 * @Author: monika
 * @Date: 2018/11/1 22:08
 * @Version: 1.0
 * @Description: 练习8：展示使用十六进制和八进制记数法来操作long值，
 *               用Long.toBinaryString()来显示结果。
 */
public class Ex08 {
    public static void main(String[] args) {
        //十六进制数
        long long1 = 0x0L;
        long long2 = 0xffffL;
        long long3 = 0L;
        long long4 = 077777L;
        Print.print("long1: " + Long.toBinaryString(long1));
        Print.print("long2: " + Long.toBinaryString(long2));
        Print.print("long3: " + Long.toBinaryString(long3));
        Print.print("long4: " + Long.toBinaryString(long4));
    }
}
/**输出：
 * long1: 0
 * long2: 1111111111111111
 * long3: 0
 * long4: 111111111111111
 */