package com.data_structures_and_algorithms.simple_sort.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/26
 * @description: 清单3.3 插入排序
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

    /**
     * 插入排序(以从小到大排序为例):
     *  在外层for循环中，out变量从1开始，向右移动。out变量标记了未排序部分的最左端的数据（被缓存到temp变量，是为了腾出位置）。
     *  内层while循环中，in变量从out变量值开始向左移动，直到temp变量小于in变量所指的数组数据项，或者它已经不能再往左移动为止。
     *  while循环的每一趟都向右移动了一个已排序的数据项。
     */
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
}

public class InsertSortApp {
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

        arr.insertionSort();
        arr.display();
    }
}
/**output:
 * 77 99 44 55 22 88 11 0 66 33
 * 0 11 22 33 44 55 66 77 88 99
 */
