//: generics/coffee/Coffee.java
package com.thinkinginjava.string.example.chapter13_3.coffee;

public class Coffee {
  private static long counter = 0;
  private final long id = counter++;
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }
} ///:~
