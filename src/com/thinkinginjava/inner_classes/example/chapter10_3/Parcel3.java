package com.thinkinginjava.inner_classes.example.chapter10_3;

/**
 *  1.在拥有外部类对象之前是不可能创建内部类对象的。这是因为内部类对象会默认地连接到
 *  创建它的外部类对象上。但是，如果你创建的是嵌套类（静态内部类），那么它就不需要对
 *  外部类对象的引用。
 */
public class Parcel3 {
  class Contents {
    private int i = 11;
    public int value() { return i; }
  }
  class Destination {
    private String label;
    Destination(String whereTo) { label = whereTo; }
    String readLabel() { return label; }
  }
  public static void main(String[] args) {
    Parcel3 p = new Parcel3();
    // Must use instance of outer class
    // to create an instance of the inner class:
    Contents c = p.new Contents();
    Destination d = p.new Destination("Tasmania");
  }
} ///:~
