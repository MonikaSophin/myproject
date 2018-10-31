package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.operators.example.chapter3_1.Print;

import java.util.Random;

/**page 46
 *
 *练习7：编写一个程序，模拟扔硬币的结果。
 */
public class Ex07 {
    public static void main(String[] args) {
        Random rand = new Random();
        int coin = rand.nextInt();
        Print.print("coin : " + coin);
        if(coin % 2 == 0)
            Print.print("heads");
        else
            Print.print("tails");
    }
}
