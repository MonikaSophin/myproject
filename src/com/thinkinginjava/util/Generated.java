package com.thinkinginjava.util;

import java.lang.reflect.Array;

public class Generated {
  // 填充现有数组:
  public static <T> T[] array(T[] a, Generator<T> gen) {
    return new CollectionData<T>(gen, a.length).toArray(a);
  }

  // 创建一个新数组:
  @SuppressWarnings("unchecked")
  public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
    T[] a = (T[]) Array.newInstance(type, size);
    return new CollectionData<>(gen, size).toArray(a);
  }
} ///:~
