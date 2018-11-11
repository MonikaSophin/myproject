package com.thinkinginjava.Initialize_clean.exercise.chapter5_9;

/**
 * @Author: monika
 * @Date: 2018/11/11 18:14
 * @Version: 1.0
 * @Description: page 107
 * 练习22：在前面的例子中，为enum写一个switch语句，对于每一个case，输出特定的货币描述。
 */

/**
 *  public enum Bills {
 *         ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
 *  }
 */
public class Ex22 {
    Ex21.Bills b;
    public static void main(String[] args) {
        for(Ex21.Bills b : Ex21.Bills.values()) {
            System.out.print("Worth: ");
            switch(b) {
                case ONE: System.out.println("$1"); break;
                case FIVE: System.out.println("$5"); break;
                case TEN: System.out.println("$10"); break;
                case TWENTY: System.out.println("$20"); break;
                case FIFTY: System.out.println("$50"); break;
                case HUNDRED: System.out.println("$100"); break;
                default: break;
            }
        }
    }
}
/**输出：
 * Worth: $1
 * Worth: $5
 * Worth: $10
 * Worth: $20
 * Worth: $50
 * Worth: $100
 */