package com.thinkinginjava.Initialize_clean.example.chapter5_9;

/**
 * @Author: monika
 * @Date: 2018/11/11 18:03
 * @Version: 1.0
 * @Description:
 */
public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values())
            System.out.println(s + ", ordinal " + s.ordinal());

    }
}
/**输出：
 * NOT, ordinal 0
 * MILD, ordinal 1
 * MEDIUM, ordinal 2
 * HOT, ordinal 3
 * FLAMING, ordinal 4
 */
