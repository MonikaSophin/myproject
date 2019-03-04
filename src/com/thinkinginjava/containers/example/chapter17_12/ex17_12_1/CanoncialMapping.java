package com.thinkinginjava.containers.example.chapter17_12.ex17_12_1;

import java.util.WeakHashMap;
import java.lang.ref.WeakReference;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/4
 * @description:
 * {@link WeakHashMap} 允许垃圾回收器自动清理键和值，所以它十分便利。
 *
 *   对于向WeakHashMap添加键和值得操作，则没有什么特殊要求。映射会自动
 * 使用{@link WeakReference}包装它们。
 *   允许清理元素的触发条件是：不再需要此键了。
 */
class Element {
    private String ident;
    public Element(String ident) { this.ident = ident; }
    @Override
    public String toString() { return ident; }
    @Override
    public int hashCode() { return ident.hashCode(); }
    @Override
    public boolean equals(Object o) {
       return o instanceof Element &&
               this.ident.equals(((Element) o).ident);
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String ident) { super(ident); }
}

class Value extends Element {
    public Value(String ident) { super(ident); }
}

public class CanoncialMapping {
    public static void main(String[] args) {
        int size = 1000;
        if (args.length > 0)
            size = new Integer(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            /**
             *   每隔2个键就持有一个引用。因此这个键的普通引用被
             * 存入了keys数组，所以这些对象不能被垃圾回收器回收。
             */
            if (i % 3 == 0) {
                keys[i] = k;
            }
            map.put(k, v);
        }
        System.gc();
    }
}
