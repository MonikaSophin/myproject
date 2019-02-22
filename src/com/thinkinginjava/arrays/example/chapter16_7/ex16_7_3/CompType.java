package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.Generator;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description:
 * {@link Arrays#sort(Object[])} :
 * 非自然数与字典排序，使用Arrays.sort()排序需要对象实现Comparable接口,
 * 否则会抛出ClassCastException运行异常。
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }
    @Override
    public String toString() {
        String result = String.format("[i = %s, j = %s]", i, j);
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }
    @Override
    public int compareTo(CompType comp) {
        return (i < comp.i ? -1 : (i == comp.i ? 0 : 1));
    }
    private static Random r = new Random(47);
    public static Generator<CompType> generator() {
        return () -> new CompType(r.nextInt(100), r.nextInt(100));
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));

        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
/**output:
 * before sorting:
 * [[i = 58, j = 55], [i = 93, j = 61], [i = 61, j = 29]
 * , [i = 68, j = 0], [i = 22, j = 7], [i = 88, j = 28]
 * , [i = 51, j = 89], [i = 9, j = 78], [i = 98, j = 61]
 * , [i = 20, j = 58], [i = 16, j = 40], [i = 11, j = 22]
 * ]
 * after sorting:
 * [[i = 9, j = 78], [i = 11, j = 22], [i = 16, j = 40]
 * , [i = 20, j = 58], [i = 22, j = 7], [i = 51, j = 89]
 * , [i = 58, j = 55], [i = 61, j = 29], [i = 68, j = 0]
 * , [i = 88, j = 28], [i = 93, j = 61], [i = 98, j = 61]
 * ]
 */