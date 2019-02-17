package com.thinkinginjava.generics.example.chapter15_11.ex15_11_3;

import com.thinkinginjava.access_control.exercise.chapter6_4.access.Widget;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
  @SuppressWarnings("unchecked")
  public void f(String[] args) throws Exception {
    ObjectInputStream in = new ObjectInputStream(
      new FileInputStream(args[0]));
    List<Widget> shapes = (List<Widget>)in.readObject();
  }
} ///:~
