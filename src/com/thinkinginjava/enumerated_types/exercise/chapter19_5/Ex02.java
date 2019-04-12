package com.thinkinginjava.enumerated_types.exercise.chapter19_5;

import com.thinkinginjava.enumerated_types.example.chapter19_5.EnumImplementation;
import com.thinkinginjava.util.Generator;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description: page 596
 * 练习02：修改{@link EnumImplementation, 编写一个static next()方法取代实现{@link Generator}接口。
 * 对比两种方式，各自有什么优缺点。
 */
enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random(47);
    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class Ex02 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.print(CartoonCharacter.next() + ", ");
    }
}
/**output:
 * BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY, SLAPPY,
 */