//: net/mindview/util/TwoTuple.java
package com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util;

public class TwoTuple<A,B> {
  public final A first;
  public final B second;
  public TwoTuple(A a, B b) { first = a; second = b; }
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
} ///:~
