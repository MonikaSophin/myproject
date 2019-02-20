package com.thinkinginjava.arrays.example.chapter16_5;

public class ArrayOfGenericType<T> {
  T[] array; // OK
  @SuppressWarnings("unchecked")
  public ArrayOfGenericType(int size) {
    //! array = new T[size]; // 非法
    array = (T[])new Object[size]; // “未检查”警告
  }
  // 非法:
  //! public <U> U[] makeArray() { return new U[10]; }
} ///:~
