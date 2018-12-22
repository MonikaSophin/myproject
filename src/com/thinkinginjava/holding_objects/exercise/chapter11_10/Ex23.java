package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/20 22:32
 * @Version: 1.0
 * @Description: page 236
 * 练习23：从Statistic.java开始，写一个程序，让它重复做测试，观察是否某个数字比
 * 别的数字出现的次数多。
 */
public class Ex23 {
    private static int getBestInt20(int n) {
        Random rand = new Random();
        Map<Integer, Integer> m =
                new TreeMap<>();
        for(int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        int max = 0;
        for(int i = 0; i < m.keySet().size(); i++) {
            max = max < m.get(i) ? m.get(i) : max;
        }
        Set<Map.Entry<Integer,Integer>> me = new
                LinkedHashSet<>(m.entrySet());
        int maxKey = 0;
        Iterator<Map.Entry<Integer,Integer>> it = me.iterator();
        while(it.hasNext()) {
            Map.Entry<Integer,Integer> findMax = it.next();
            if(findMax.getValue() == max)
                maxKey = findMax.getKey();
        }
        return maxKey;
    }
    public static void main(String[] args) {
        Map<Integer,Integer> m20 =
                new TreeMap<>();
        for(int i = 0; i < 2000; i++) {
            int x = getBestInt20(10000);
            Integer freq = m20.get(x);
            m20.put(x, freq == null ? 1 : freq + 1);
        }
        System.out.println("在10,000次随机选择的2000次测试中，大多数情况下经常选择0到19的整数： " + m20);
    }
}
/**output:
 * 在10,000次随机选择的2000次测试中，大多数情况下经常选择0到19的整数： {0=117, 1=83, 2=112, 3=78, 4=82, 5=122, 6=112, 7=113, 8=78, 9=89, 10=96, 11=94, 12=115, 13=102, 14=93, 15=105, 16=96, 17=99, 18=114, 19=100}
 */