package com.thinkinginjava.generics.example.chapter15_8.ex15_8_2;//: generics/GenericArray.java

public class GenericArray<T> {
  private T[] array;
  @SuppressWarnings("unchecked")
  public GenericArray(int sz) {
    array = (T[])new Object[sz];
  }
  public void put(int index, T item) {
    array[index] = item;
  }
  public T get(int index) { return array[index]; }

  // 公开底层表示的方法:
  public T[] rep() { return array; }

  public static void main(String[] args) {
    GenericArray<Integer> gai =
      new GenericArray<>(10);

    // 这会导致 ClassCastException:
    //! Integer[] ia = gai.rep();

    // This is OK:
    Object[] oa = gai.rep();
  }
} ///:~
