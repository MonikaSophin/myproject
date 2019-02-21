package com.thinkinginjava.arrays.exercise.chapter16_7;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 451
 * 练习18：创建并填充一个BerylliumSphere数组，将这个数组复制到一个新数组，并展示
 * 这是一种浅复制。
 */
public class Ex18 {
    public static void main(String[] args) {
        BerylliumSphere[] bsa1 = new BerylliumSphere[3];
        for(int i = 0; i < bsa1.length; i++)
            bsa1[i] = new BerylliumSphere();
        // Arrays.fill(bsa1, new BerylliumSphere());
        System.out.println(Arrays.toString(bsa1));

        BerylliumSphere[] bsa2 = new BerylliumSphere[4];
        System.out.println(Arrays.toString(bsa2));

        System.arraycopy(bsa1, 0, bsa2, 0, bsa1.length);
        System.out.println(Arrays.toString(bsa2));
        // 没有在bsa2中创建新的BerylliumSpheres，只是对bsa1中的那些新引用
    }
}
/**output:
 * [Shpere 0, Shpere 1, Shpere 2]
 * [null, null, null, null]
 * [Shpere 0, Shpere 1, Shpere 2, null]
 */