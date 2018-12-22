package com.thinkinginjava.holding_objects.exercise.chapter11_6;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/15 15:38
 * @Version: 1.0
 * @Description: page 227
 * 练习11：写一个方法，使用Iterator遍历Collection,并打印容器中的每个对象的toString(),
 * 填充各种类型的Collection,然后对其使用此方法。
 */
public class Ex11 {
    public static void iterators(Collection collection){
        Iterator iterator = collection.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] ints = {1,2,2,3,4,5,5,6};
        Collection c1 = new ArrayList();
        Collection c2 = new LinkedList();
        Collection c3 = new HashSet();
        Collection c4 = new LinkedHashSet();
        Collection c5 = new TreeSet();

        c1.addAll(Arrays.asList(ints));
        c2.addAll(Arrays.asList(ints));
        c3.addAll(Arrays.asList(ints));
        c4.addAll(Arrays.asList(ints));
        c5.addAll(Arrays.asList(ints));

        iterators(c1);
        iterators(c2);
        iterators(c3);
        iterators(c4);
        iterators(c5);
    }
}
/**输出：
 * 1 2 2 3 4 5 5 6
 * 1 2 2 3 4 5 5 6
 * 1 2 3 4 5 6
 * 1 2 3 4 5 6
 * 1 2 3 4 5 6
 */