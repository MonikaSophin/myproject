package com.thinkinginjava.string.example.chapter13_2;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/12/31 14:51
 * @Version: 1.0
 * @Description:
 */
public class UsingStringBuilder {
    public static Random rand = new Random(47);
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(". ");
        }
        result.delete(result.length() - 2,result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
/**output:
 * [58. 55. 93. 61. 61. 29. 68. 0. 22. 7. 88. 28. 51. 89. 9. 78. 98. 61. 20. 58. 16. 40. 11. 22. 4]
 */