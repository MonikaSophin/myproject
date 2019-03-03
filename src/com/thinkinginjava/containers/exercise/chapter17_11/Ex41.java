package com.thinkinginjava.containers.exercise.chapter17_11;

import com.thinkinginjava.util.RandomGenerator;

import java.util.*;

import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/3/3 22:11
 * @Version: 1.0
 * @Description: page 515
 * 练习41：修改前一个练习中的类，使其可以作用于HashSet，并可以用作HashMap中的键。
 */
class TwoStrings41 implements Comparable<TwoStrings41> {
    private String first = "";
    private String second = "";
    public TwoStrings41(String s1, String s2) {
        first = s1;
        second = s2;
    }
    //仅使用第一个String进行比较：
    @Override
    public int compareTo(TwoStrings41 ts) {
        return first.compareTo(ts.first);
    }
    @Override
    public String toString() {
        return String.format("<%s & %s>", first, second);
    }
    static void printArray(TwoStrings41[] sa) {
        printnb("(");
        for(int i = 0; i < sa.length - 1; i++)
            printnb(sa[i] + ", ");
        print(sa[sa.length - 1] + ")");
    }
    // 使用第二个String进行比较的可选内部类：
    public static class Comp2 implements Comparator<TwoStrings41> {
        @Override
        public int compare(TwoStrings41 ts1, TwoStrings41 ts2) {
            return ts1.second.compareTo(ts2.second);
        }
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        RandomGenerator.Integer rgi = new RandomGenerator.Integer(100);
        Set<TwoStrings41> set = new HashSet<>();
        Map<TwoStrings41,Integer> map = new HashMap<>();
        for(int i = 0; i < 4; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            set.add(new TwoStrings41(s1, s2));
            map.put(new TwoStrings41(s1, s2), rgi.next());
        }
        print("Set: " + set);
        print("Map: " + map);
        print("map.keySet(): " + map.keySet());
        print();

        print("Sorted by first String:");
        Set<TwoStrings41> treeSet = new TreeSet<>(set);
        Map<TwoStrings41,Integer> treeMap = new TreeMap<>(map);
        print("TreeSet: " + treeSet);
        print("TreeMap: " + treeMap);
        print();

        print("Sorted by second String:");
        TwoStrings41.Comp2 comp = new TwoStrings41.Comp2();
        Set<TwoStrings41> treeSet2 = new TreeSet<>(comp);
        Map<TwoStrings41,Integer> treeMap2 = new TreeMap<>(comp);
        treeSet2.addAll(treeSet);
        treeMap2.putAll(treeMap);
        print("TreeSet2: " + treeSet2);
        print("TreeMap2: " + treeMap2);
    }
}

public class Ex41 {
    public static void main(String[] args) {
        TwoStrings41.main(args);
    }
}
/**output:
 * Set: [<YNzb & rnyG>, <FOWZ & nTcQ>, <GseG & ZMmJ>, <RoEs & uEcU>]
 * Map: {<GseG & ZMmJ>=6, <RoEs & uEcU>=96, <YNzb & rnyG>=22, <FOWZ & nTcQ>=61}
 * map.keySet(): [<GseG & ZMmJ>, <RoEs & uEcU>, <YNzb & rnyG>, <FOWZ & nTcQ>]
 *
 * Sorted by first String:
 * TreeSet: [<FOWZ & nTcQ>, <GseG & ZMmJ>, <RoEs & uEcU>, <YNzb & rnyG>]
 * TreeMap: {<FOWZ & nTcQ>=61, <GseG & ZMmJ>=6, <RoEs & uEcU>=96, <YNzb & rnyG>=22}
 *
 * Sorted by second String:
 * TreeSet2: [<GseG & ZMmJ>, <FOWZ & nTcQ>, <YNzb & rnyG>, <RoEs & uEcU>]
 * TreeMap2: {<GseG & ZMmJ>=6, <FOWZ & nTcQ>=61, <YNzb & rnyG>=22, <RoEs & uEcU>=96}
 */