package com.thinkinginjava.containers.exercise.chapter17_5;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description: page 477
 * 练习08：创建一个泛型的单向链表类SList，为了简单起见，不要让它去实现List接口。列表中的每个Link对象
 * 都应该包含一个对列表中下一个元素而不是前一个元素的引用（与这个类相比，LinkedList是双向链表，它包含
 * 两个方向的链接）。创建你自己的SListIterator，同样为了简单起见，不要实现ListIterator。SList中除了
 * toString()之外唯一的方法应该是iterator()，它将产生一个SListIterator。在SList中插入和移动元素的
 * 唯一方式就是通过SListIterator。编写代码来演示SList。
 */
class SList<E> {
    private Link<E> headLink = new Link<>(null);
    SListIterator<E> iterator() {
        return new SListIterator<>(headLink);
    }
    public String toString() {
        if(headLink.next == null)
            return "SList: []";
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while(it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return "SList: [" + s + "]";
    }
}

class SListIterator<E> {
    Link<E> current;
    SListIterator(Link<E> link) {
        current = link;
    }
    public boolean hasNext() {
        return current.next != null;
    }
    public Link<E> next() {
        current = current.next;
        return current;
    }
    public void insert(E e) {
        current.next = new Link<>(e, current.next);
        current = current.next;
    }
    public void remove() {
        if(current.next != null) {
            current.next = current.next.next;
        }
    }
}

class Link<E> {
    E e;
    Link<E> next;
    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }
    Link(E e) {
        this(e, null);
    }
    public String toString() {
        if(e == null)
            return "null";
        return e.toString();
    }
}

public class Ex08 {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();
        print(sl);
        SListIterator<String> slIter = sl.iterator();
        print("inserting \"hi\"");
        slIter.insert("hi");
        print(sl);
        print("inserting \"there\"");
        slIter.insert("there");
        print(sl);
        print("inserting \"sweetie\"");
        slIter.insert("sweetie");
        print(sl);
        print("inserting \"pie\"");
        slIter.insert("pie");
        print(sl);
        SListIterator<String> slIter2 = sl.iterator();
        print("removing \"hi\"");
        slIter2.remove();
        print(sl);
        print("inserting \"hello\"");
        slIter2.insert("hello");
        print(sl);
        print("removing \"there\"");
        slIter2.remove();
        print(sl);
        print("removing \"sweetie\"");
        slIter2.remove();
        print(sl);
        print("removing \"pie\"");
        slIter2.remove();
        print(sl);
        print("removing \"hello\"");
        SListIterator slIter3 = sl.iterator();
        slIter3.remove();
        print(sl);
    }
}
/**output:
 * SList: []
 * inserting "hi"
 * SList: [hi]
 * inserting "there"
 * SList: [hi, there]
 * inserting "sweetie"
 * SList: [hi, there, sweetie]
 * inserting "pie"
 * SList: [hi, there, sweetie, pie]
 * removing "hi"
 * SList: [there, sweetie, pie]
 * inserting "hello"
 * SList: [hello, there, sweetie, pie]
 * removing "there"
 * SList: [hello, sweetie, pie]
 * removing "sweetie"
 * SList: [hello, pie]
 * removing "pie"
 * SList: [hello]
 * removing "hello"
 * SList: []
 */