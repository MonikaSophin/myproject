package com.thinkinginjava.holding_objects.exercise.chapter11_7;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @Author: monika
 * @Date: 2018/12/15 16:28
 * @Version: 1.0
 * @Description: page 229
 * 练习14：创建一个空的LinkedList<Integer>,通过使用ListIterator,将若干个Integer
 * 插入这个List中，插入时，总是将它们插入到List的中间。
 */
public class Ex14 {
    static void addMiddle(LinkedList<Integer> l, Integer[] ia) {
        for(Integer i : ia) {
            ListIterator<Integer> it =
                    l.listIterator((l.size())/2);
            it.add(i);
            System.out.println(l);
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<Integer>();
        Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
        Ex14.addMiddle(li, x);
    }
}
/**输出：
 * [0]
 * [1, 0]
 * [1, 2, 0]
 * [1, 3, 2, 0]
 * [1, 3, 4, 2, 0]
 * [1, 3, 5, 4, 2, 0]
 * [1, 3, 5, 6, 4, 2, 0]
 * [1, 3, 5, 7, 6, 4, 2, 0]
 */