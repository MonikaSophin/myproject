package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.util.CountingGenerator;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习13：用CountingGenerator.Character填充一个String.
 */
public class Ex13 {
    public static void main(String[] args) {
        String s;
        char[] chars = new char[10];
        CountingGenerator.Character c = new CountingGenerator.Character();
        for (int i = 0; i < chars.length; i++)
            chars[i] = c.next();

        s = new String(chars);

        System.out.println(String.format("char[] = %s", Arrays.toString(chars)));
        System.out.println(String.format("String = %s", s));
    }
}
/**output:
 * char[] = [a, b, c, d, e, f, g, h, i, j]
 * String = abcdefghij
 */