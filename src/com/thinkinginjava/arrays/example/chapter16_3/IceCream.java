package com.thinkinginjava.arrays.example.chapter16_3;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = { "Chocolate", "Strawberry", "Vanilla_Fudge_Swirl",
            "Mint_Chip", "Mocha_Almond_Fudge", "Rum_Raisin", "Praline_Cream", "Mud_Pie"};
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            }while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
/**output:
 * Rum_Raisin, Mint_Chip, Mocha_Almond_Fudge]
 * [Chocolate, Strawberry, Mocha_Almond_Fudge]
 * [Strawberry, Mint_Chip, Mocha_Almond_Fudge]
 * [Rum_Raisin, Vanilla_Fudge_Swirl, Mud_Pie]
 * [Vanilla_Fudge_Swirl, Chocolate, Mocha_Almond_Fudge]
 * [Praline_Cream, Strawberry, Mocha_Almond_Fudge]
 * [Mocha_Almond_Fudge, Strawberry, Mint_Chip]
 */