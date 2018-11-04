package com.thinkinginjava.operators.exercise;

/**page 49
 * @Author: monika
 * @Date: 2018/11/1 22:33
 * @Version: 1.0
 * @Description: 练习9：分别显示用float和double指数记数法所能表示的最大和最小的数字。
 */
public class Ex09 {
    public static void main(String[] args) {
        float float1 = Float.MAX_VALUE;
        float float2 = Float.MIN_VALUE;
        System.out.println("float类型最大值为 " + float1);
        System.out.println("float类型最小值为 " + float2);

        double double1 = Double.MAX_VALUE;
        double double2 = Double.MIN_VALUE;
        System.out.println("double类型最大值为 " + double1);
        System.out.println("double类型最小值为 " + double2);
    }
}
