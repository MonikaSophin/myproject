package com.data_structures_and_algorithms.simple_sort.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/25
 * @description: 清单3.2 选择排序
 */
class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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

    //选择排序，比较的时间复杂度为O(n²)，交换的时间复杂度为O（n）
    public void selectSort() {
        int min;
        for (int out = 0; out < nElems - 1; out++) {
            min = out;//设置最小元素的下标。
            for (int in = out + 1; in < nElems; in++)
                if (a[min] > a[in]){
                    min = in;//找出最小值得下标，与之交换
                }
            long temp = a[out];
            a[out] = a[min];
            a[min] = temp;
        }
    }

    //这样的选择排序（暂时先这么叫），比较的时间复杂度为O(n²)，在交换的时间复杂度与冒泡排序的时间复杂度是一样的，为O(n²)
    public void selectSort2() {
        for (int out = 0; out < nElems; out++) {
            for (int in = out + 1; in < nElems; in++) {
                if (a[out] > a[in]) {
                    long temp = a[out];
                    a[out] = a[in];
                    a[in] = temp;
                }
            }
        }
    }
}

public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arr;
        arr = new ArraySel(maxSize);

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

        arr.selectSort();
        arr.display();
    }
}
/**output:
 * 77 99 44 55 22 88 11 0 66 33
 * 0 11 22 33 44 55 66 77 88 99
 */