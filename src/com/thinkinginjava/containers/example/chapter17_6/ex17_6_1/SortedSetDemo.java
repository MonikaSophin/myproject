package com.thinkinginjava.containers.example.chapter17_6.ex17_6_1;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description:
 * {@link SortedSet#first()} :返回容器的第一个元素
 * {@link SortedSet#last()} :返回容器的最后一个元素
 * {@link SortedSet#subSet(Object, Object)} :返回[)左闭右开区间的set子集
 * {@link SortedSet#headSet(Object)} :小于该元素的set子集
 * {@link SortedSet#tailSet(Object)} :大于或等于该元素的set子集
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        print(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        print(low);
        print(high);

        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3)
                low = it.next();
            if (i == 6)
                high = it.next();
            else
                it.next();
        }
        print(low);
        print(high);

        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
    }
}
/**output:
 * [eight, five, four, one, seven, six, three, two]
 * eight
 * two
 * one
 * two
 * [one, seven, six, three]
 * [eight, five, four, one, seven, six, three]
 * [one, seven, six, three, two]
 */