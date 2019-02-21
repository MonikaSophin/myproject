package com.thinkinginjava.util;

import java.util.HashSet;
import java.util.Set;

public class Sets {
  /**
   * 并集
   */
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<>(a);
    result.addAll(b);
    return result;
  }

  /**
   * 交集
   */
  public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.retainAll(b);
    return result;
  }

  /**
   * 从超集中减去子集
   */
  public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<T>(superset);
    result.removeAll(subset);
    return result;
  }

  /**
   * 集合a与集合b的并集 减去 集合a与集合b的交集
   */
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
} ///:~
