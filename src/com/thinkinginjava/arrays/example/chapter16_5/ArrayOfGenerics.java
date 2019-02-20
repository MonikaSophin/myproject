package com.thinkinginjava.arrays.example.chapter16_5;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la; //“未检查”警告

        // 编译错误
        //! ls[1] = new ArrayList<Integer>();

        // 问题：List <String>是Object的子类型
        Object[] objects = ls; // So assignment is OK
        // 编译并运行无错误:
        objects[1] = new ArrayList<Integer>();

        // 如果您的需求很简单，则可以创建一系列泛型，尽管带有“未检查”警告:
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10]; //“未检查”警告
        for(int i = 0; i < spheres.length; i++)
            spheres[i] = new ArrayList<>();
    }
}
