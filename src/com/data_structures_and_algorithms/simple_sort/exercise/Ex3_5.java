package com.data_structures_and_algorithms.simple_sort.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/28
 * @description: page 79
 * 练习3.5：修改InsertSortApp.java程序（清单3.3）中的insertionSort()方法，使它可以计算排序过程中复制
 * 和比较次数并显示出总数。为计算比较的次数，要把内层的while循环的两个条件分开。用这个程序测量各种数
 * 量的逆序数据排序的复制和比较次数。结果满足O(n²)吗？与已经基本有序的数据（仅有很少的数据无序）的情
 * 况一样吗？从对基本有序数据排序的表现中可得出关于这个算法效率的什么结论？
 */
class ArrayIns3 {
    private long[] a;
    private int nElems;

    public ArrayIns3(int max) {
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
        int compare = 0;//比较次数
        int copy = 0;//复制次数
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0) {
                if (a[in - 1] >= temp) {
                    a[in] = a[in - 1];
                    --in;
                    compare++;
                    copy++;
                } else {
                    compare++;
                    break;//若不满足条件，跳出循环。
                }
            }
            a[in] = temp;
        }

        System.out.println("比较的次数: " + compare);
        System.out.println("复制的次数: " + copy);
        System.out.println("比较与复制的总次数: " + (copy + compare));
    }
}

public class Ex3_5 {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns3 arr;
        arr = new ArrayIns3(maxSize);

        arr.insert(99);
        arr.insert(88);
        arr.insert(77);
        arr.insert(66);
        arr.insert(55);
        arr.insert(44);
        arr.insert(33);
        arr.insert(22);
        arr.insert(11);
        arr.insert(00);
        arr.display();

        arr.insertionSort();
        arr.display();

        System.out.println("----------------------------");

        ArrayIns3 arr2;
        arr2 = new ArrayIns3(maxSize);

        arr2.insert(11);
        arr2.insert(00);
        arr2.insert(22);
        arr2.insert(33);
        arr2.insert(44);
        arr2.insert(55);
        arr2.insert(66);
        arr2.insert(77);
        arr2.insert(88);
        arr2.insert(99);
        arr2.display();

        arr2.insertionSort();
        arr2.display();

        //从output可以直观的看到，逆序的数据进行排序比较与复制的次数满足O(n²)，而基本有序的数据满足O(n)。
    }
}
/**output:
 * 99 88 77 66 55 44 33 22 11 0
 * 比较的次数: 45
 * 复制的次数: 45
 * 比较与复制的总次数: 90
 * 0 11 22 33 44 55 66 77 88 99
 * ----------------------------
 * 11 0 22 33 44 55 66 77 88 99
 * 比较的次数: 9
 * 复制的次数: 1
 * 比较与复制的总次数: 10
 * 0 11 22 33 44 55 66 77 88 99
 */