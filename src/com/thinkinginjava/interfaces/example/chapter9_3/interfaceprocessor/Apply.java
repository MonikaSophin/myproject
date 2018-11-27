package com.thinkinginjava.interfaces.example.chapter9_3.interfaceprocessor;

public class Apply {
  public static void process(Processor p, Object s) {
    System.out.println("Using Processor " + p.name());
    System.out.println(p.process(s));
  }
} ///:~
