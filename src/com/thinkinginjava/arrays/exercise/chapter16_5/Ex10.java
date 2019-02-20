package com.thinkinginjava.arrays.exercise.chapter16_5;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 442
 * 练习10：修改ArrayOfGenerics.java，在其中使用容器而不是数组。展示你可以根除
 * 编译期警告信息。
 */
public class Ex10 {
    public static void main(String[] args) {
        List<List<String>> list1 = new ArrayList<>();
        List<List> list2 = new ArrayList<>();
        // 编译错误：不可转换的类型
        //! list1 = (List<List<String>>)list2;
        list1.add(new ArrayList<>());

        List<Object> list3 = new ArrayList<>();
        // 编译错误：不兼容的类型
        //! list3 = list1;

        // 编译时警告消除了:
        List<List<BerylliumSphere>> list4 = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            list4.add(new ArrayList<>());
            for(int j = 0; j < 2; j++)
                list4.get(i).add(new BerylliumSphere());
        }
        System.out.println(list4);
    }
}
/**output:
 * [[Shpere 0, Shpere 1], [Shpere 2, Shpere 3], [Shpere 4, Shpere 5]]
 */
