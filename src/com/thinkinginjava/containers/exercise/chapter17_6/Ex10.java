package com.thinkinginjava.containers.exercise.chapter17_6;

import java.util.Iterator;
import java.util.LinkedList;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description: page 480
 * 练习10：使用LinkedList作为底层实现，定义你自己的SortedSet。
 */
class MySortedSet<E> extends LinkedList<E> {
    int myCompare(E e1, E e2) {
        int result = e1.hashCode() - e2.hashCode();
        return result < 0 ? -1 : (result == 0 ? 0 : 1);
    }

    @Override
    public boolean add(E e) {
        if (!this.contains(e)){// 去重
            Iterator<E> it = this.iterator();
            int index = 0;
            while(it.hasNext()){
                if ( myCompare(it.next(), e) < 1)
                    index++;
            }
            add(index, e);
            return true;
        }
        return false;
    }
}

class T {}

public class Ex10 {
    public static void main(String[] args) {
        MySortedSet<T> ss = new MySortedSet<>();
        ss.add(new T());
        ss.add(new T());
        ss.add(new T());
        ss.add(new T());
        print(ss);
        MySortedSet<Integer> ss2 = new MySortedSet<>();
        ss2.add(6);
        ss2.add(8);
        ss2.add(2);
        ss2.add(4);
        ss2.add(2);
        ss2.add(8);
        print(ss2);
        MySortedSet<String> ss3 = new MySortedSet<>();
        ss3.add("three");
        ss3.add("three");
        ss3.add("seven");
        ss3.add("hi");
        ss3.add("two");
        ss3.add("one");
        print(ss3);
    }
}
/**output:
 * [com.thinkinginjava.containers.exercise.chapter17_6.T@38cccef, com.thinkinginjava.containers.exercise.chapter17_6.T@4c3e4790, com.thinkinginjava.containers.exercise.chapter17_6.T@4f47d241, com.thinkinginjava.containers.exercise.chapter17_6.T@5679c6c6]
 * [2, 4, 6, 8]
 * [hi, one, two, seven, three]
 */