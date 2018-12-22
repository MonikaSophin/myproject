package com.thinkinginjava.holding_objects.exercise.chapter11_6;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/15 15:10
 * @Version: 1.0
 * @Description: page 227
 * 练习09：修改innerclass/Sequence.java，使得在Sequence中，用Iterator取代Selector。
 */
class Sequence {
    private List list;
    public Sequence(int size) { list = new ArrayList(); }
    public void add(Object x) {
       list.add(x);
    }

    public Iterator getIterator(){
        return list.iterator();
    }
}
public class Ex09 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        Iterator iterator = sequence.getIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
/**输出：
 * 0 1 2 3 4 5 6 7 8 9
 */