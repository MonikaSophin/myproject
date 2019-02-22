package com.thinkinginjava.arrays.exercise.chapter16_7;

import java.util.Arrays;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description: page 457
 * 练习24：通过程序说明练习19中的类是可查找的。
 */
class A24 implements Comparable<A24> {
    protected int x;
    A24(int x) { this.x = x; }
    @Override
    public boolean equals(Object b) {
        return (b.getClass().getSimpleName() == "A24"
                && this.x == ((A24)b).x) ? true : false;
    }
    @Override
    public String toString() { return String.format("A24{%s}", x); }
    @Override
    public int compareTo(A24 b) {
        return (this.x < b.x ? -1 : (this.x == b.x ? 0 : 1));
    }
}

public class Ex24 {
    public static void main(String[] args) {
        A24[] a = { new A24(1), new A24(2), new A24(3), new A24(4), new A24(5) };
        print(Arrays.toString(a));

        Arrays.sort(a);
        int index = Arrays.binarySearch(a, new A24(3));
        print("Index: " + index + ", " + a[index]);
    }
}
/**output:
 * [A24{1}, A24{2}, A24{3}, A24{4}, A24{5}]
 * Index: 2, A24{3}
 */