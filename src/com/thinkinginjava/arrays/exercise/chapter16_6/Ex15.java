package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.Generator;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习15：修改ContainerComparison.java，创建一个用于BerylliumSphere的Generator，
 * 并修改main()方法，再将这个Generator作用于Generated.array()。
 */
class ContainerComparison {
    static class SphereGenerator implements Generator<BerylliumSphere> {
        @Override
        public BerylliumSphere next() { return new BerylliumSphere(); }
    }
}

public class Ex15 {
    public static void main(String[] args) {
        BerylliumSphere[] a = Generated.array(BerylliumSphere.class,
                new ContainerComparison.SphereGenerator(), 6);
        System.out.println(Arrays.toString(a));
    }
}
/**output:
 * [Shpere 0, Shpere 1, Shpere 2, Shpere 3, Shpere 4, Shpere 5]
 */