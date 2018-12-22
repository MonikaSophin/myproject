package com.thinkinginjava.holding_objects.example.chapter11_1;//: holding/GenericsAndUpcasting.java
import java.util.*;

class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericsAndUpcasting {
  public static void main(String[] args) {
    ArrayList<Apple> apples = new ArrayList<Apple>();
    apples.add(new GrannySmith());
    apples.add(new Gala());
    apples.add(new Fuji());
    apples.add(new Braeburn());
    for(Apple c : apples)
      System.out.println(c);
  }
}
/** Output: (Sample)
 * com.thinkinginjava.holding_objects.example.chapter11_1.GrannySmith@4554617c
 * com.thinkinginjava.holding_objects.example.chapter11_1.Gala@74a14482
 * com.thinkinginjava.holding_objects.example.chapter11_1.Fuji@1540e19d
 * com.thinkinginjava.holding_objects.example.chapter11_1.Braeburn@677327b6
 */
