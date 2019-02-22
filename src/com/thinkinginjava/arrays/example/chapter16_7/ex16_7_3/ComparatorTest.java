package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_3;

import java.util.Arrays;
import java.util.Comparator;
import com.thinkinginjava.util.Generated;
import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description:
 * {@link Comparator}:定义比较规则。
 * {@link Arrays#sort(Object[], Comparator)} :将自定义的比较规则应用于排序。
 */
class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));

        Arrays.sort(a, new CompTypeComparator());
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
 * [[i = 68, j = 0], [i = 22, j = 7], [i = 11, j = 22]
 * , [i = 88, j = 28], [i = 61, j = 29], [i = 16, j = 40]
 * , [i = 58, j = 55], [i = 20, j = 58], [i = 93, j = 61]
 * , [i = 98, j = 61], [i = 9, j = 78], [i = 51, j = 89]
 */