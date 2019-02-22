package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_5;

import com.thinkinginjava.util.ConvertTo;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.Generator;
import com.thinkinginjava.util.RandomGenerator;

import java.util.Arrays;

import static com.thinkinginjava.util.Print.*;
/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description:
 */
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen =
                new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(
                Generated.array(new Integer[25], gen));
        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                print(String.format("Location of %s is %s, a[%s] = %s", r, location, location, a[location]));
                break;
            }
        }
    }
}
