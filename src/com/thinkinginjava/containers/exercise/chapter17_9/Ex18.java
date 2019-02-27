package com.thinkinginjava.containers.exercise.chapter17_9;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/27
 * @description: page 492
 * 练习18：参考SlowMap.java，创建一个SlowSet。
 */
class SlowSet<E> extends AbstractSet<E> {
    private List<E> list = new ArrayList<>();
    @Override
    public boolean add(E e) {
        if (list.contains(e))
            return false;
        return list.add(e);
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = -1;
            @Override
            public boolean hasNext() { return index < list.size() - 1; }
            @Override
            public E next() { return list.get(++index); }
        };
    }
    @Override
    public int size() { return list.size(); }
    @Override
    public boolean remove(Object o) {
        if (list.contains(o)){
            list.remove(list.indexOf(o));
            return true;
        }
        return false;
    }
}

public class Ex18 {
    public static void main(String[] args) {
        SlowSet<String> set = new SlowSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");
        System.out.println(String.format("set: %s", set));
        System.out.println(String.format("set.size(): %s", set.size()));
        System.out.println(String.format("set.remove(\"1\"): %s", set.remove("1")));
        Iterator<String> it = set.iterator();
        System.out.print("set.iterator(): ");
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
/**output:
 * set: [1, 2, 3]
 * set.size(): 3
 * set.remove("1"): true
 * set.iterator(): 2 3
 */