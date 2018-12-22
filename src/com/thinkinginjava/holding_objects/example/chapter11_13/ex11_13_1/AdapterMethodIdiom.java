package com.thinkinginjava.holding_objects.example.chapter11_13.ex11_13_1;

import java.util.*;

class ReversibleArrayList<T> extends ArrayList<T> {
  public ReversibleArrayList(Collection<T> c) { super(c); }
  public Iterable<T> reversed() {
    return new Iterable<T>() {
      @Override
      public Iterator<T> iterator() {
        return new Iterator<T>() {
          int current = size() - 1;
          public boolean hasNext() { return current > -1; }
          public T next() { return get(current--); }
          public void remove() { // Not implemented
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }
}	

public class AdapterMethodIdiom {
  public static void main(String[] args) {
    ReversibleArrayList<String> ral =
      new ReversibleArrayList<String>(
        Arrays.asList("To be or not to be".split(" ")));
    // 通过iterator（）获取普通的迭代器：
    for(String s : ral)
      System.out.print(s + " ");
    System.out.println();
    // 把它交给您选择的Iterable
    for(String s : ral.reversed())
      System.out.print(s + " ");
  }
}
/** Output:
To be or not to be
be to not or be To
*///:~
