package com.thinkinginjava.arrays.exercise.chapter16_7;

import com.thinkinginjava.util.ConvertTo;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.RandomGenerator;
import java.util.Arrays;
import java.util.Random;
import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description: page 457
 * 练习22：通过程序说明在未排序数组上执行binarySearch()方法的结果是不可预知的。
 */
public class Ex22 {
    private static Random r = new Random();
    public static void main(String[] args) {
        int[] ia = ConvertTo.primitive(Generated.array(new Integer[20],
                new RandomGenerator.Integer(10)));
        print(Arrays.toString(ia));

        for(int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if(index < 0)
                print(i + " not found");
            else
                print("Index: " + index + ", " + i);
        }
        print("----------------sort----------------");

        Arrays.sort(ia);
        print(Arrays.toString(ia));

        for(int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if(index < 0)
                print(i + " not found");
            else
                print("Index: " + index + ", " + i);
        }
    }
}
/**output:
 * [8, 5, 3, 1, 1, 9, 8, 0, 2, 7, 8, 8, 1, 9, 9, 8, 8, 1, 0, 8]
 * 0 not found
 * Index: 4, 1
 * 2 not found
 * 3 not found
 * 4 not found
 * 5 not found
 * 6 not found
 * Index: 9, 7
 * Index: 11, 8
 * Index: 14, 9
 * ----------------sort----------------
 * [0, 0, 1, 1, 1, 1, 2, 3, 5, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9]
 * Index: 1, 0
 * Index: 4, 1
 * Index: 6, 2
 * Index: 7, 3
 * 4 not found
 * Index: 8, 5
 * 6 not found
 * Index: 9, 7
 * Index: 14, 8
 * Index: 17, 9
 */