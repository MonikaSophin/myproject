package com.thinkinginjava.containers.example.chapter17_9.ex17_9_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description:
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    public CountedString(String s) {
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
        result = 37 * result + id;
        return result;
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString)o).s) &&
               id == ((CountedString)o).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString c : cs) {
            System.out.println("Looking up: " + c);
            System.out.println(map.get(c));
        }
    }
}
/**output:
 * {[String:hi id:4 hashCode():146450]=3, [String:hi id:5 hashCode():146451]=4, [String:hi id:2 hashCode():146448]=1, [String:hi id:3 hashCode():146449]=2, [String:hi id:1 hashCode():146447]=0}
 * Looking up: [String:hi id:1 hashCode():146447]
 * 0
 * Looking up: [String:hi id:2 hashCode():146448]
 * 1
 * Looking up: [String:hi id:3 hashCode():146449]
 * 2
 * Looking up: [String:hi id:4 hashCode():146450]
 * 3
 * Looking up: [String:hi id:5 hashCode():146451]
 * 4
 */
