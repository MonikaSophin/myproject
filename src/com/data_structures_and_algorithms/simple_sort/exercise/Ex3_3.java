package com.data_structures_and_algorithms.simple_sort.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/26
 * @description: page 78
 * 练习3.3: 在InsertSortApp.java程序（清单3.3）中增加一个noDups()的方法，这个方法从已经有序
 * 的数组中删掉重复的数据项而不破坏有序性。（可以用insertionSort()方法对数据排序，或者也可以
 * 简单地用main()方法将数据有序地插入到表中。）一种解决方法是每发现一个重复的数据，就从这个位置
 * 开始到数组结尾都向前移动一个位置，但这样就导致消耗很长的O(N²)的时间段，起码在有很多重复数据项
 * 的情况下是这样的。在设计的算法中，不论有多少重复数据，要确保数据项最多只能移动一次。这样算法就
 * 只消耗O(N)数量级的时间。
 */
class ArrayIns2 {
    private long[] a;
    private int nElems;

    public ArrayIns2(int max) {
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

    //插入排序
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

    public void noDups(){
        //保证数组有序
        insertionSort();
        //设置重复数据为-1
        long NULL = -1;
        for (int i = 0; i < nElems; i++)
            for (int j = i+1 ; j < nElems; j++)
                if (a[i] != NULL && a[i] == a[j])
                    a[j] = NULL;

        System.out.println("将重复元素置为-1后：");
        display();

       //去除重复数据，并且保证数组元素只移动一次
        int noDupsCount = 0;
        for (int i = 0; i < nElems; i++) {
            if(a[i] != NULL){
                a[noDupsCount] = a[i];
                noDupsCount++;
                // =等价于=>
                // a[noDupsCount++] = a[i];
            }
        }
        nElems = noDupsCount;
    }
}

public class Ex3_3 {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns2 arr;
        arr = new ArrayIns2(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(77);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(44);
        arr.insert(55);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(88);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(11);
        arr.insert(33);
        arr.insert(33);
        arr.insert(66);
        arr.insert(33);
        arr.insert(33);
        arr.insert(00);
        arr.display();

        arr.noDups();
        arr.display();
    }
}
/**output:
 * 77 99 77 77 99 44 55 44 55 55 22 88 88 22 88 11 0 66 11 33 33 66 33 33 0
 * 将重复元素置为-1后：
 * 0 -1 11 -1 22 -1 33 -1 -1 -1 44 -1 55 -1 -1 66 -1 77 -1 -1 88 -1 -1 99 -1
 * 0 11 22 33 44 55 66 77 88 99
 */