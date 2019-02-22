package com.thinkinginjava.arrays.exercise.chapter16_7;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.Generator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description: page 454
 * 练习21：试着对练习18中的对象数组进行排序。
 */
class BerylliumSphere21 implements Comparable<BerylliumSphere21>{
    public long id;
    public BerylliumSphere21(long id) { this.id = id; }
    @Override
    public String toString() { return "Shpere " + id; }
    @Override
    public int compareTo(BerylliumSphere21 bery) {
        return (this.id < bery.id ? -1 : (this.id == bery.id ? 0 : 1));
    }
    private static Random r = new Random(47);
    public static Generator<BerylliumSphere21> generator() {
        return () -> new BerylliumSphere21(r.nextInt(100));
    }
}

class BerylliumSphere21Comparator implements Comparator<BerylliumSphere21> {
    @Override
    public int compare(BerylliumSphere21 o1, BerylliumSphere21 o2) {
        return  (o1.id > o2.id ? -1 : (o1.id == o2.id ? 0 : 1));
    }
}


public class Ex21 {
    public static void main(String[] args) {
        BerylliumSphere[] b1 = new BerylliumSphere[6];
        for (int i = 0; i < b1.length; i++)
            b1[i] = new BerylliumSphere();
        // 运行异常：ClassCastException: BerylliumSphere cannot be cast to java.lang.Comparable
        // Arrays.sort(b1);

        BerylliumSphere21[] b2 =
                Generated.array(new BerylliumSphere21[8], BerylliumSphere21.generator());
        print("before sorting:");
        print(Arrays.toString(b2));

        Arrays.sort(b2);
        print("after sorting:");
        print(Arrays.toString(b2));

        Arrays.sort(b2, new BerylliumSphere21Comparator());
        print("reverse sorting:");
        print(Arrays.toString(b2));
    }
}
/**output:
 * before sorting:
 * [Shpere 58, Shpere 55, Shpere 93, Shpere 61, Shpere 61, Shpere 29, Shpere 68, Shpere 0]
 * after sorting:
 * [Shpere 0, Shpere 29, Shpere 55, Shpere 58, Shpere 61, Shpere 61, Shpere 68, Shpere 93]
 * reverse sorting:
 * [Shpere 93, Shpere 68, Shpere 61, Shpere 61, Shpere 58, Shpere 55, Shpere 29, Shpere 0]
 */