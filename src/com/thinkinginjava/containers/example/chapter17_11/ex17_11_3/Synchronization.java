package com.thinkinginjava.containers.example.chapter17_11.ex17_11_3;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2019/3/3 23:10
 * @Version: 1.0
 * @Description:
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(
                new ArrayList<>());
        List<String> list = Collections.synchronizedList(
                new ArrayList<>());
        Set<String> s = Collections.unmodifiableSet(
                new HashSet<>());

        Set<String> ss = Collections.synchronizedSortedSet(
                new TreeSet<>());
        Map<String, String> m = Collections.synchronizedMap(
                new HashMap<>());
        Map<String, String> sm = Collections.synchronizedSortedMap(
                new TreeMap<>());
    }
}
