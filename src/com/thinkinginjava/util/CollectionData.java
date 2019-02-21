package com.thinkinginjava.util;

import java.util.ArrayList;

/**
 * 使用生成器对象填充数据的集合
 */
public class CollectionData<T> extends ArrayList<T> {
  public CollectionData(Generator<T> gen, int quantity) {
    for(int i = 0; i < quantity; i++)
      add(gen.next());
  }

  // 通用便捷方法:
  public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
    return new CollectionData<>(gen, quantity);
  }
} ///:~
