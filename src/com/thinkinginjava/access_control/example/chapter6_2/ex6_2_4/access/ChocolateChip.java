package com.thinkinginjava.access_control.example.chapter6_2.ex6_2_4.access;

import com.thinkinginjava.access_control.example.chapter6_2.ex6_2_2.access.dessert.Cookie;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:40
 * @Version: 1.0
 * @Description:
 */
public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }
    public void chomp() {
        //! bite(); // Can't access bite
    }
    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
/**输出：
 * Cookie constructor
 * ChocolateChip constructor
 */
