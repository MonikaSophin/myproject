package com.thinkinginjava.holding_objects.exercise.chapter11_5;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/13 22:59
 * @Version: 1.0
 * @Description: page 226
 * 练习06：修改ListFeatures.java，让它使用String而不是Pet，并解释在结果上有何不同。
 */
public class Ex06 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<String> ls = new ArrayList<>();
        System.out.println("0: " + ls);
        Collections.addAll(ls, "oh", "what", "a", "beautiful", "Manila", "Monday", "morning");
        System.out.println("1: " + ls);
        String h = new String("hi");
        ls.add(h);
        System.out.println("2: " + ls);
        System.out.println("3: " + ls.contains(h));
        // removes the first instance equivalent to String h:
        ls.remove(h);
        System.out.println("3.5: " + ls);
        String p = ls.size() > 2 ? ls.get(2) : null;
        System.out.println("4: " + p + " " +  ls.indexOf(p));
        String cy = new String("cy");
        System.out.println("5: " + cy +" " + ls.indexOf(cy));
        System.out.println("6: " + ls.remove(cy));
        System.out.println("7: " + ls.remove(p));
        System.out.println("8: " + ls);
        if(ls.size() > 3)
            ls.add(3, "wonderful");
        System.out.println("9: " + ls);
        if(ls.size() < 4) {
            List<String> s =
                    Arrays.asList("let's", "jump", "in", "here");
            ls.addAll(0, s);
        }
        List<String> sub = ls.subList(1, 4);
        System.out.println("sublist: " + sub);
        System.out.println("10: " + ls.containsAll(sub));
        // will also sort sub elements within ls:
        Collections.sort(sub);
        System.out.println("sorted sublist: " + sub);
        System.out.println("11: " + ls.containsAll(sub));
        System.out.println("11.25: " + ls);
        // will also shuffle sub elements within ls:
        Collections.shuffle(sub, rand);
        System.out.println("11.5: " + ls);
        System.out.println("shuffled sublist: " + sub);
        System.out.println("12: " + ls.containsAll(sub));
        List<String> copy = new ArrayList<String>(ls);
        System.out.println("12.5: " + ls);
        if(ls.size() < 5) {
            ls.add("two");
            ls.add("more");
        }
        sub = Arrays.asList(ls.get(1), ls.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<String>(ls);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        if(copy.size() > 1) // to avoid out of bounds exception
            copy.set(1, "excellent");
        System.out.println("16: " + copy);
        if(copy.size() > 2)
            copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + ls.isEmpty());
        ls.clear();
        System.out.println("19: " + ls);
        System.out.println("20: " + ls.isEmpty());
        ls.addAll(0, sub);
        ls.addAll(2, sub);
        System.out.println("21: " + ls);
        Object[] o = ls.toArray();
        System.out.println("22: " + o[3]);
        String[] sa = ls.toArray(new String[0]);
        System.out.println("23: " + sa[3]);
    }
}
/**输出：
 * 0: []
 * 1: [oh, what, a, beautiful, Manila, Monday, morning]
 * 2: [oh, what, a, beautiful, Manila, Monday, morning, hi]
 * 3: true
 * 3.5: [oh, what, a, beautiful, Manila, Monday, morning]
 * 4: a 2
 * 5: cy -1
 * 6: false
 * 7: true
 * 8: [oh, what, beautiful, Manila, Monday, morning]
 * 9: [oh, what, beautiful, wonderful, Manila, Monday, morning]
 * sublist: [what, beautiful, wonderful]
 * 10: true
 * sorted sublist: [beautiful, what, wonderful]
 * 11: true
 * 11.25: [oh, beautiful, what, wonderful, Manila, Monday, morning]
 * 11.5: [oh, beautiful, wonderful, what, Manila, Monday, morning]
 * shuffled sublist: [beautiful, wonderful, what]
 * 12: true
 * 12.5: [oh, beautiful, wonderful, what, Manila, Monday, morning]
 * sub: [beautiful, Manila]
 * 13: [beautiful, Manila]
 * 14: [oh, beautiful, what, Manila, Monday, morning]
 * 15: [oh, what, Monday, morning]
 * 16: [oh, excellent, Monday, morning]
 * 17: [oh, excellent, beautiful, Manila, Monday, morning]
 * 18: false
 * 19: []
 * 20: true
 * 21: [beautiful, Manila, beautiful, Manila]
 * 22: Manila
 * 23: Manila
 */