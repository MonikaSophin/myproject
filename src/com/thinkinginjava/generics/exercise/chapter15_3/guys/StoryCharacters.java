//: generics/coffee/Coffee.java
package com.thinkinginjava.generics.exercise.chapter15_3.guys;

public class StoryCharacters {
  protected static long counter = 0;
  protected final long id = counter++;
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }
} ///:~
