package com.thinkinginjava.containers.exercise.chapter17_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description: page 399
 * 练习27：修改CountedString.java中的hashCode()，移除与id的绑定，并且证明
 * CountedString仍能正常作为键使用。这种方式有没有问题？
 */
class CountedString27 {
    private String s;
    private int id = 0;
    private static List<String> created = new ArrayList<>();
    public CountedString27(String s) {
        this.s = s;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(this.s))
                id++;
        }
    }
    @Override
    public String toString() {
        return String.format("[String:%s id:%s hashCode():%s]",
                s, id, hashCode());
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString26 &&
                s.equals(((CountedString27)o).s) &&
                id == ((CountedString27)o).id;
    }
}

public class Ex27 {
    public static void main(String[] args) {
        Map<CountedString27, Integer> map = new HashMap<>();
        CountedString27[] cs = new CountedString27[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString27("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString27 c : cs) {
            System.out.println("Looking up: " + c);
        }
    }
}
/**output:
 * {[String:hi id:1 hashCode():3958]=0, [String:hi id:2 hashCode():3958]=1, [String:hi id:3 hashCode():3958]=2, [String:hi id:4 hashCode():3958]=3, [String:hi id:5 hashCode():3958]=4}
 * Looking up: [String:hi id:1 hashCode():3958]
 * Looking up: [String:hi id:2 hashCode():3958]
 * Looking up: [String:hi id:3 hashCode():3958]
 * Looking up: [String:hi id:4 hashCode():3958]
 * Looking up: [String:hi id:5 hashCode():3958]
 */