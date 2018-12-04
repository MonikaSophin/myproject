package com.thinkinginjava.inner_classes.example.chapter10_3;

/**
 * 1.有时你可能想要告知某些其他对象，去创建其某个内部类的对象。要实现此目的，你必须
 * 在new表达式中提供对其他外部类对象的引用，这是需要使用.new语法。
 */
public class DotNew {
  public class Inner {}
  public static void main(String[] args) {
    DotNew dn = new DotNew();
    Inner dni = dn.new Inner();
  }
} ///:~
