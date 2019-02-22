package com.thinkinginjava.arrays.exercise.chapter16_7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description: page 457
 * 练习22：创建一个Integer数组，用随机的int数值填充它（使用自动包装机制），
 * 再使用Comparator将其进行反向排序。
 */
public class Ex23 {
    public static void main(String[] args) {
        Random r = new Random(47);
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++)
            a[i] = r.nextInt(100);

        print("before sorting:");
        print(Arrays.toString(a));

        Arrays.sort(a, Collections.reverseOrder());
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
/**output:
 * before sorting:
 * [58, 55, 93, 61, 61, 29, 68, 0, 22, 7]
 * after sorting:
 * [93, 68, 61, 61, 58, 55, 29, 22, 7, 0]
 */