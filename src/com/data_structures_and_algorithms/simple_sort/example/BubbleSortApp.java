package com.data_structures_and_algorithms.simple_sort.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/25
 * @description: 清单3.1 冒泡排序
 */
class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
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

    //省略delete find ...

    //冒泡排序
    public void bubbleSort() {
        int out, in;
        int count = 0;//比较次数计数
        for (out = 0; out < nElems; out++) {
            //-out是为了避免将排好序的元素再一次比较，从而减少比较次数。 -1是为了避免数组下标越界。
            for (in = 0; in < nElems - out - 1; in++) {
                if (a[in] > a[in + 1]) {//若不-1，此处的in+1会造成数组下标越界。
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
                count++;
            }
        }
        System.out.println("总的比较次数： " + count);
    }
}

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

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

        arr.bubbleSort();
        arr.display();
    }
}
/**
 * output:
 * 77 99 44 55 22 88 11 0 66 33
 * 总的比较的次数： 45
 * 0 11 22 33 44 55 66 77 88 99
 */