package com.thinkinginjava.containers.example.chapter17_6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description:
 */
class SetType {
    int i;
    public SetType(int i) { this.i = i; }
    @Override
    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType)o).i);
    }
    @Override
    public String toString() { return Integer.toString(i); }
}

class HashType extends SetType {
    public HashType(int i) { super(i); }
    @Override
    public int hashCode() { return i; }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) { super(i); }
    @Override
    public int compareTo(TreeType o) {
        return (o.i < i ? -1 : (o.i == i ? 0 : 1));
    }
}

public class TypesForSets {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++)
                set.add(type.getConstructor(int.class).newInstance(i));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType.class);
        test(new LinkedHashSet<>(), HashType.class);
        test(new TreeSet<>(), TreeType.class);
        System.out.println();

        test(new HashSet<>(), SetType.class);
        test(new HashSet<>(), TreeType.class);
        test(new LinkedHashSet<>(), SetType.class);
        test(new LinkedHashSet<>(), TreeType.class);
        System.out.println();

        try {
            test(new TreeSet<>(), SetType.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), HashType.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
 *
 * [1, 1, 4, 2, 0, 9, 8, 3, 5, 5, 7, 6, 7, 3, 5, 7, 0, 9, 8, 0, 2, 2, 1, 4, 6, 9, 4, 8, 6, 3]
 * [6, 3, 5, 1, 5, 8, 4, 4, 3, 3, 8, 2, 1, 4, 7, 2, 2, 0, 7, 9, 9, 5, 0, 6, 1, 6, 8, 0, 7, 9]
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 * java.lang.ClassCastException: com.thinkinginjava.containers.example.chapter17_6.SetType cannot be cast to java.lang.Comparable
 * java.lang.ClassCastException: com.thinkinginjava.containers.example.chapter17_6.HashType cannot be cast to java.lang.Comparable
 */