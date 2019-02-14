package com.thinkinginjava.generics.example.chapter15_10;//: generics/GenericsAndCovariance.java

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
  public static void main(String[] args) {
    // 通配符允许协方差:
    List<? extends Fruit> flist = new ArrayList<Apple>();
    // 编译错误：无法添加任何类型的对象:
    // flist.add(new Apple());
    // flist.add(new Fruit());
    // flist.add(new Object());
    flist.add(null); // 合法但无意义
    // 我们知道它至少会回归Fruit:
    Fruit f = flist.get(0);
  }
} ///:~
