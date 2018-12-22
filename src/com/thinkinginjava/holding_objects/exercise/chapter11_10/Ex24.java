package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/20 22:39
 * @Version: 1.0
 * @Description: page 236
 * 练习04：使用String“键”和你选择地对象填充LinkedHashMap。然后从中提取键值对，
 * 以键排序，然后重新插入此Map。
 */
public class Ex24 {
    public static void main(String[] args) {
        Map<String, Integer> m =
                new LinkedHashMap<>();
        m.put("ten", 10);
        m.put("nine", 9);
        m.put("eight", 8);
        m.put("seven", 7);
        m.put("six", 6);
        m.put("five", 5);
        m.put("four", 4);
        m.put("three", 3);
        m.put("two", 2);
        m.put("one", 1);
        m.put("zero", 0);
        System.out.println("Map to sort: " + m);

        // 临时存储map，并删除源map中的元素
        Map<String, Integer> mTemp =
                new LinkedHashMap<>();
        Set<String> ss = new TreeSet<>(m.keySet());
        Iterator<String> itss = ss.iterator();
        while (itss.hasNext()) {
            String s = itss.next();
            Integer i = m.get(s);
//            m.remove(s);
            mTemp.put(s, i);
        }
        m.clear();
        System.out.println("temp map: " + mTemp);

        //填充源map
        m.putAll(mTemp);


//        Set<String> ssTemp =
//                new TreeSet<>(mTemp.keySet());
//        Iterator<String> itssTemp = ssTemp.iterator();
//        while(itssTemp.hasNext()) {
//            String s = (String)itssTemp.next();
//            Integer i = mTemp.get(s);
//            mTemp.remove(s);
//            m.put(s, i);
//        }
        mTemp.clear();
        System.out.println("Sorted map: " + m);
    }
}
/**
 * Map to sort: {ten=10, nine=9, eight=8, seven=7, six=6, five=5, four=4, three=3, two=2, one=1, zero=0}
 * temp map: {eight=8, five=5, four=4, nine=9, one=1, seven=7, six=6, ten=10, three=3, two=2, zero=0}
 * Sorted map: {eight=8, five=5, four=4, nine=9, one=1, seven=7, six=6, ten=10, three=3, two=2, zero=0}
 */