package com.thinkinginjava.enumerated_types.example.chapter19_5;

import com.thinkinginjava.util.Generator;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);
    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        // 构建任意一个CartoonCharacter实例
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
            printNext(cc);
    }
}
/**output:
 * BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY, SLAPPY,
 */