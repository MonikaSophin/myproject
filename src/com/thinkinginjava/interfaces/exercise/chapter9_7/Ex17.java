package com.thinkinginjava.interfaces.exercise.chapter9_7;

/**
 * @Author: monika
 * @Date: 2018/11/27 21:16
 * @Version: 1.0
 * @Description: page 184
 * 练习17：证明在接口中的域隐式地式static和final的。
 */
interface Days {
    int SUNDAY = 1, MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4,
            THURSDAY = 5, FRIDAY = 6, SATURDAY = 7;
}

class Week implements Days {
    private static int count = 0;
    private int id = count++;
    public Week() { System.out.println("Week() " + id); }
}

public class Ex17 {
    public static void main(String[] args) {
        // 没有任何对象，存在静态字段
        System.out.println("SUNDAY = " + Days.SUNDAY);
        System.out.println("MONDAY = " + Days.MONDAY);
        Week w0 = new Week();
        Week w1 = new Week();
        // 错误：无法为最终变量SUNDAY分配值：
        // w.SUNDAY = 2;
        // 错误：无法为最终变量MONDAY分配值：
        // w1.MONDAY = w0.MONDAY;
    }
}
/**输出：
 * SUNDAY = 1
 * MONDAY = 2
 * Week() 0
 * Week() 1
 */