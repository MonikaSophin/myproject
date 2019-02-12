package com.thinkinginjava.generics.example.chapter15_4.ex15_4_6;

import com.thinkinginjava.generics.example.chapter15_4.ex15_4_6.util.Sets;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/11
 * @description:
 */
public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method method : type.getMethods())
            result.add(method.getName());
        return result;
    }
    static void ineterfaces(Class<?> type) {
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces())
            result.add(c.getSimpleName());
        System.out.format("Interfaces in %s: %s \n", type.getSimpleName(), result);
    }
    static Set<String> object = methodSet(Object.class);
    static { object.add("clone"); }
    static void difference(Class<?> superset, Class<?> subset) {
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);// 去除Object方法
        System.out.println(String.format("%s extends %s, add: %s",
                superset.getSimpleName(), subset.getSimpleName(), comp));
        ineterfaces(superset);
        System.out.println("-------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        ineterfaces(Collection.class);
        System.out.println();
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);

        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);

        System.out.println();
        System.out.println("Map: " + methodSet(Map.class));
        ineterfaces(Map.class);
        System.out.println();
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
        difference(ConcurrentMap.class, Map.class);
    }
}
/**output:
 * Collection: [add, addAll, clear, contains, containsAll, equals, forEach, hashCode, isEmpty, iterator, parallelStream, remove, removeAll, removeIf, retainAll, size, spliterator, stream, toArray]
 * Interfaces in Collection: [Iterable]
 *
 * Set extends Collection, add: []
 * Interfaces in Set: [Collection]
 * -------------------------------------------------------------
 * HashSet extends Set, add: []
 * Interfaces in HashSet: [Set, Cloneable, Serializable]
 * -------------------------------------------------------------
 * LinkedHashSet extends HashSet, add: []
 * Interfaces in LinkedHashSet: [Set, Cloneable, Serializable]
 * -------------------------------------------------------------
 * TreeSet extends Set, add: [headSet, descendingIterator, descendingSet, pollLast, subSet, floor, tailSet, ceiling, last, lower, comparator, pollFirst, first, higher]
 * Interfaces in TreeSet: [NavigableSet, Cloneable, Serializable]
 * -------------------------------------------------------------
 * List extends Collection, add: [replaceAll, get, indexOf, subList, set, sort, lastIndexOf, listIterator]
 * Interfaces in List: [Collection]
 * -------------------------------------------------------------
 * ArrayList extends List, add: [trimToSize, ensureCapacity]
 * Interfaces in ArrayList: [List, RandomAccess, Cloneable, Serializable]
 * -------------------------------------------------------------
 * LinkedList extends List, add: [offerFirst, poll, getLast, offer, getFirst, removeFirst, element, removeLastOccurrence, peekFirst, peekLast, push, pollFirst, removeFirstOccurrence, descendingIterator, pollLast, removeLast, pop, addLast, peek, offerLast, addFirst]
 * Interfaces in LinkedList: [List, Deque, Cloneable, Serializable]
 * -------------------------------------------------------------
 * Queue extends Collection, add: [poll, peek, offer, element]
 * Interfaces in Queue: [Collection]
 * -------------------------------------------------------------
 * PriorityQueue extends Queue, add: [comparator]
 * Interfaces in PriorityQueue: [Serializable]
 * -------------------------------------------------------------
 *
 * Map: [clear, compute, computeIfAbsent, computeIfPresent, containsKey, containsValue, entrySet, equals, forEach, get, getOrDefault, hashCode, isEmpty, keySet, merge, put, putAll, putIfAbsent, remove, replace, replaceAll, size, values]
 * Interfaces in Map: []
 *
 * HashMap extends Map, add: []
 * Interfaces in HashMap: [Map, Cloneable, Serializable]
 * -------------------------------------------------------------
 * LinkedHashMap extends HashMap, add: []
 * Interfaces in LinkedHashMap: [Map]
 * -------------------------------------------------------------
 * SortedMap extends Map, add: [lastKey, subMap, comparator, firstKey, headMap, tailMap]
 * Interfaces in SortedMap: [Map]
 * -------------------------------------------------------------
 * TreeMap extends Map, add: [descendingKeySet, navigableKeySet, higherEntry, higherKey, floorKey, subMap, ceilingKey, pollLastEntry, firstKey, lowerKey, headMap, tailMap, lowerEntry, ceilingEntry, descendingMap, pollFirstEntry, lastKey, firstEntry, floorEntry, comparator, lastEntry]
 * Interfaces in TreeMap: [NavigableMap, Cloneable, Serializable]
 * -------------------------------------------------------------
 * ConcurrentMap extends Map, add: []
 * Interfaces in ConcurrentMap: [Map]
 * -------------------------------------------------------------
 */