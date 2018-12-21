package com.data_structures_and_algorithms.array.exercise;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/18
 * @description: page 50
 * 练习2.3 编程作业2.2中的removeMax()方法提供了一种通过关键字值进行数组排序的方法。实现
 * 一个排序放方案，要求不修改HighArray类，只需对main()中的代码进行修改。这个方法需要第二
 * 个数组，在排序结束时数组数据项是逆序排列的。（这个方法是第3章“简单排序”中选择排序的一个
 * 变体。）
 */
class HighArray3 {
    private long[] a;
    private int nElems;

    public HighArray3(int max) {
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

    public long getMax() {
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

    public long removeMax() {
        if (nElems == 0)
            return -1;
        else {
            long[] b = Arrays.copyOf(a, nElems);
            for (int i = 0; i < nElems; i++) {
                for (int j = i + 1; j < nElems; j++) {
                    if (b[i] < b[j]) {
                        long temp = b[i];
                        b[i] = b[j];
                        b[j] = temp;
                    }
                }
            }
            //删除
            delete(b[0]);
            return b[0];
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    //逆序排序(选择排序)
    public void reverseDisplay() {
        long[] b = Arrays.copyOf(a, nElems);
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (b[i] < b[j]) {
                    long temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        for (int i = 0; i < nElems; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}

public class Ex2_3 {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray3 arr;
        arr = new HighArray3(maxSize);

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
        arr.reverseDisplay();

        int searchkey = 35;
        if (arr.find(searchkey))
            System.out.println("Found " + searchkey);
        else
            System.out.println("Can't find " + searchkey);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
        arr.reverseDisplay();
    }
}
/**
 * 输出：
 * 77 99 44 55 22 88 11 0 66 33
 * 99 88 77 66 55 44 33 22 11 0
 * Can't find 35
 * 77 44 22 88 11 66 33
 * 88 77 66 44 33 22 11
 */