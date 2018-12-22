package com.thinkinginjava.holding_objects.exercise.chapter11_5;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/13 22:30
 * @Version: 1.0
 * @Description: page 225
 * 练习05：修改ListFeatures.java,让它使用Integer(记住自动包装机制！)而不是Pet,
 * 并解释在结果上有何不同。
 */
public class Ex05 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> lists = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        System.out.println("1: " + lists);
        Integer integer6 = 5;
        lists.add(integer6); // Automatically resizes
        System.out.println("2: " + lists);
        System.out.println("3: " + lists.contains(integer6));
        lists.remove(integer6); // Remove by object
        Integer integer2 = lists.get(2);
        System.out.println("4: " +  integer2 + " " + lists.indexOf(integer2));
        System.out.println("5: " + lists.indexOf(integer6));
        System.out.println("6: " + lists.remove(integer2));
        // Must be the exact object:
        System.out.println("7: " + lists.remove(integer2));
        System.out.println("8: " + lists);
        lists.add(3, 22); // Insert at an index
        System.out.println("9: " + lists);
        List<Integer> sub = lists.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + lists.containsAll(sub));
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        System.out.println("11: " + lists.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + lists.containsAll(sub));
        List<Integer> copy = new ArrayList<>(lists);
        sub = Arrays.asList(lists.get(1), lists.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(lists); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, 11); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + lists.isEmpty());
        lists.clear(); // Remove all elements
        System.out.println("19: " + lists);
        System.out.println("20: " + lists.isEmpty());
        lists.addAll(Arrays.asList(100,101,102,103,104));
        System.out.println("21: " + lists);
        Object[] o = lists.toArray();
        System.out.println("22: " + o[3]);
        /**
         * {@link ArrayList#toArray(Object[])}
         * <code>
         * if (a.length < size)
         *     //若指定目标数组的长度小于源list大小，则直接复制到目标数组{@link ArrayList#toArray()}
         *     return (T[]) Arrays.copyOf(elementData, size, a.getClass());
         * //若指定目标数组的长度等于源list大小，同上述效果。{@link System#arraycopy(Object, int, Object, int, int)}
         * System.arraycopy(elementData, 0, a, 0, size);
         * if (a.length > size)
         *      //若指定目标数组的长度大于源list大小，超过size大小的数组下标元素为null.
         *      a[size] = null;
         *  return a;
         *  </code>
         */
        Integer[] integers = lists.toArray(new Integer[0]);
        System.out.println("23: " + integers[3]);
    }
}
/**输出：
 * 1: [0, 1, 2, 3, 4]
 * 2: [0, 1, 2, 3, 4, 5]
 * 3: true
 * 4: 2 2
 * 5: -1
 * 6: true
 * 7: false
 * 8: [0, 1, 3, 4]
 * 9: [0, 1, 3, 22, 4]
 * subList: [1, 3, 22]
 * 10: true
 * sorted subList: [1, 3, 22]
 * 11: true
 * shuffled subList: [3, 1, 22]
 * 12: true
 * sub: [3, 4]
 * 13: [3, 4]
 * 14: [0, 3, 22, 4]
 * 15: [0, 22]
 * 16: [0, 11]
 * 17: [0, 11, 3, 4]
 * 18: false
 * 19: []
 * 20: true
 * 21: [100, 101, 102, 103, 104]
 * 22: 103
 * 23: 103
 */