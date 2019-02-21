package com.thinkinginjava.util;

import java.util.LinkedHashMap;

/**
 * 使用生成器对象填充数据的映射.
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {
  // 单对generator:
  public MapData(Generator<Pair<K,V>> gen, int quantity) {
    for(int i = 0; i < quantity; i++) {
      Pair<K,V> p = gen.next();
      put(p.key, p.value);
    }
  }
  // 两个独立的generator:
  public MapData(Generator<K> genK, Generator<V> genV,
      int quantity) {
    for(int i = 0; i < quantity; i++) {
      put(genK.next(), genV.next());
    }
  }
  // 密钥生成器和单个值:
  public MapData(Generator<K> genK, V value, int quantity){
    for(int i = 0; i < quantity; i++) {
      put(genK.next(), value);
    }
  }
  // 一个Iterable和一个值generator:
  public MapData(Iterable<K> genK, Generator<V> genV) {
    for(K key : genK) {
      put(key, genV.next());
    }
  }
  // 一个Iterable和一个单独的值:
  public MapData(Iterable<K> genK, V value) {
    for(K key : genK) {
      put(key, value);
    }
  }
  // 通用便利方法:
  public static <K,V> MapData<K,V>
  map(Generator<Pair<K,V>> gen, int quantity) {
    return new MapData<K,V>(gen, quantity);
  }
  public static <K,V> MapData<K,V>
  map(Generator<K> genK, Generator<V> genV, int quantity) {
    return new MapData<K,V>(genK, genV, quantity);
  }
  public static <K,V> MapData<K,V>
  map(Generator<K> genK, V value, int quantity) {
    return new MapData<K,V>(genK, value, quantity);
  }
  public static <K,V> MapData<K,V>
  map(Iterable<K> genK, Generator<V> genV) {
    return new MapData<K,V>(genK, genV);
  }
  public static <K,V> MapData<K,V>
  map(Iterable<K> genK, V value) {
    return new MapData<K,V>(genK, value);
  }
} ///:~
