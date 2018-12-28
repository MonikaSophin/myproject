package com.data_structures_and_algorithms.simple_sort.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/26
 * @description: page 78
 * 练习3.2：在InsertSortApp.java程序（清单3.3）中给ArrayIns类加一个median()方法。这个方法将返回
 * 数组的中间值。（回忆一下，数组中一半数据项比中间值大，一半数据项比中间小值。）
 */
class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    //省略 delete() find()

    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    public long median() {
        insertionSort();
        return a[nElems / 2];
    }
}

public class Ex3_2 {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

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

        System.out.println("Middle value: " + arr.median());
        arr.display();
    }
}
/**
 * output:
 * 77 99 44 55 22 88 11 0 66 33
 * Middle value: 55
 * 0 11 22 33 44 55 66 77 88 99
 */