package com.thinkinginjava.containers.exercise.chapter17_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description: page 499
 * 练习26：在CountedString中添加一个char域，它也将在构造器中初始化，然后修改
 * hashCode()和equals()方法，使它们都包含这个char域的值。
 */
class CountedString26 {
    private String s;
    private int id = 0;
    private char c;
    private static List<String> created = new ArrayList<>();
    public CountedString26(char c, String s) {
        this.s = s;
        this.c = c;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(this.s))
                id++;
        }
    }
    @Override
    public String toString() {
        return String.format("[c:%s String:%s id:%s hashCode():%s]",
                c, s, id, hashCode());
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = result + c;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString26 &&
                s.equals(((CountedString26)o).s) &&
                id == ((CountedString26)o).id &&
                c == ((CountedString26)o).c;
    }
}

public class Ex26 {
    public static void main(String[] args) {
        Map<CountedString26, Integer> map = new HashMap<>();
        CountedString26[] cs = new CountedString26[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString26('A', "hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString26 c : cs) {
            System.out.println("Looking up: " + c);
            System.out.println(map.get(c));
        }
    }
}
/**output:
 * {[c:A String:hi id:4 hashCode():235435]=3, [c:A String:hi id:3 hashCode():235434]=2, [c:A String:hi id:2 hashCode():235433]=1, [c:A String:hi id:1 hashCode():235432]=0, [c:A String:hi id:5 hashCode():235436]=4}
 * Looking up: [c:A String:hi id:1 hashCode():235432]
 * 0
 * Looking up: [c:A String:hi id:2 hashCode():235433]
 * 1
 * Looking up: [c:A String:hi id:3 hashCode():235434]
 * 2
 * Looking up: [c:A String:hi id:4 hashCode():235435]
 * 3
 * Looking up: [c:A String:hi id:5 hashCode():235436]
 */
