package com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:35
 * @Version: 1.0
 * @Description:
 */
public class AutoboxingVarargs {
    public static void f(Integer... args) {
        for(Integer i : args)
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        f(new Integer(1), new Integer(2));
        f(4, 5, 6, 7, 8, 9);
        f(10, new Integer(11), 12);
    }
}
/**输出：
 * 1 2
 * 4 5 6 7 8 9
 * 10 11 12
 *
 * 结论：  你可以在单一的参数列表中将类型混合在一起，
 *    而自动包装机制将有选择地将int参数提升为Integer。
 */
