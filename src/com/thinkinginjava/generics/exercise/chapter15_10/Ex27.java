package com.thinkinginjava.generics.exercise.chapter15_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description: page 391
 * 练习27：使用Number和Integer，然后引入通配符，以此展示协变性对List不起作用。
 */
public class Ex27 {
    public static void main(String[] args) {
        // 编译错误：不兼容的类型:
        // List<Number> lnum = new ArrayList<Integer>();
        List<? extends Number> nlist = new ArrayList<Integer>();

        // 编译错误：无法添加Integer，也无法添加任何类型的对象：
        // nlist.add(new Integer(0));
        // nlist.add(new Double(3.14));
        nlist.add(null); // 可以添加 null
        Number x = nlist.get(0); // 会得到 Number (null)
        System.out.println(nlist);
    }
}
