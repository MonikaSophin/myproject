package com.thinkinginjava.generics.example.chapter15_7.ex15_7_4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class ListMaker<T> {
    List<T> create() {
        //return new ArrayList(); // 此处会有警告
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> strings = stringMaker.create();
    }
}
