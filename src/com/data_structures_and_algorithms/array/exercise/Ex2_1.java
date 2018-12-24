package com.data_structures_and_algorithms.array.exercise;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/17
 * @description: page 50
 * 练习2.1：向highArray.java程序（清单2.3）的HighArray类添加一个名为getMax()的方法，它返回
 * 数组中最大关键字的值，当数组为空时返回-1。向main()中添加一些代码来使用这个方法。可以假设所
 * 有关键字都正数。
 */
class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    //解法1：
    public long getMax() {
        long max = -1;//设置最大值
        if (nElems == 0)
            return -1;
        else {
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max)
                    max = a[i];
            }
        }
        return max;
    }

    //解法2：
    public long getMax2() {
        if (nElems == 0)
            return -1;
        else {
            long[] b = Arrays.copyOf(a, nElems);
            for (int i = 0; i < nElems; i++) {
                if (b[0] < b[i])
                    b[0] = b[i];
            }
            return b[0];
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class Ex2_1 {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();
        System.out.println("getMax() " + arr.getMax());

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
        System.out.println("getMax() " + arr.getMax());
    }
}
/**
 * 输出：
 * 77 99 44 55 22 88 11 0 66 33
 * getMax() 99
 * 77 44 22 88 11 66 33
 * getMax() 88
 */