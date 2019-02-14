package com.thinkinginjava.generics.example.chapter15_10.ex15_10_3;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards1 {
  static List list1;
  static List<?> list2;
  static List<? extends Object> list3;
  static void assign1(List list) {
    list1 = list;
    list2 = list;
    // 警告：未经检查的转化。找到：List，必填：List<？ extends Object>
    // list3 = list;
  }
  static void assign2(List<?> list) {
    list1 = list;
    list2 = list;
    list3 = list;
  }	
  static void assign3(List<? extends Object> list) {
    list1 = list;
    list2 = list;
    list3 = list;
  }
  public static void main(String[] args) {
    assign1(new ArrayList());
    assign2(new ArrayList());
    // 警告：未经检查的转化。找到：ArrayList 必需：List <？ extends Object>
    // assign3(new ArrayList());

    assign1(new ArrayList<String>());
    assign2(new ArrayList<String>());
    assign3(new ArrayList<String>());

    // 这两种形式都可以作为List <？>:
    List<?> wildList = new ArrayList();
    wildList = new ArrayList<String>();
    assign1(wildList);
    assign2(wildList);
    assign3(wildList);
  }
} ///:~
