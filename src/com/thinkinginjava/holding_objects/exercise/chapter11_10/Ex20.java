package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import com.thinkinginjava.holding_objects.example.chapter11_9.TextFile;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/19 23:07
 * @Version: 1.0
 * @Description: page 236
 * 练习20：修改练习16，使得你可以跟踪每一个元音字母出现的次数。
 */
public class Ex20 {
    static void vowelCounter(Set<String> st) {
        Set<Character> element = new TreeSet<>();
        element.addAll(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

        Map<Character, Integer> map = new TreeMap<>();
        int allCount = 0;
        for (String s : st) {
            for (Character v : s.toCharArray()) {
                if (element.contains(v)) {
                    Integer count = map.get(v);
                    map.put(v, count == null ? count = 1 : ++count);
                    allCount++;
                }
            }
        }
        System.out.println(map);
        System.out.println("Total vowels: " + allCount);
    }

    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(
                new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
    }
}
/**output:
 * [A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N, Output, Set, SetOperations, String, System, X, Y, Z, add, addAll, added, args, chapter11_9, class, com, contains, containsAll, example, false, from, holding_objects, import, in, java, main, new, out, package, println, public, remove, removeAll, removed, set1, set2, split, static, thinkinginjava, to, true, util, void]
 *
 * {A=4, E=1, I=1, O=2, a=20, e=23, i=18, o=16, u=6}
 * Total vowels: 91
 */