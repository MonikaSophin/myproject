package com.thinkinginjava.holding_objects.exercise.chapter11_6;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: monika
 * @Date: 2018/12/15 15:48
 * @Version: 1.0
 * @Description: page 228
 * 练习12：创建并组装一个List<Integer>,然后创建第二个具有相同尺寸的List<Integer>,
 * 并使用ListIterator读取第一个List中的元素，然后再将它们以反序插入到第二个列表中（你
 * 可能想探索该问题的各种不同的解决之道）。
 */
public class Ex12 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <=5 ; i++)
            list1.add(i);
        List<Integer> list2 = new ArrayList<>(list1.size());

        System.out.println("List1的iterator:");
        ListIterator<Integer> it1 = list1.listIterator();
        while(it1.hasNext())
            System.out.print(it1.next() + " ");
        System.out.println();
        //此时list1的指针在下标为4的位置。

        //现在反向去取值。
        while(it1.hasPrevious())
            list2.add(it1.previous());
        System.out.println("List2的iterator:");
        ListIterator<Integer> it2 = list2.listIterator();
        while(it2.hasNext())
            System.out.print(it2.next() + " ");

    }
}
