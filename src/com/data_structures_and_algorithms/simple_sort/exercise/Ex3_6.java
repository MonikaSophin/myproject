package com.data_structures_and_algorithms.simple_sort.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/28
 * @description: page 79
 * 练习3.6：有一个有趣的方法用来删除数组中相同的数据项。插入排序算法中用一个循环嵌套算法，
 * 将数组中的每一个数据项与其他数据项一一比较。如果要删除相同的数据项，可以这样做（参见第
 * 2章第2.6小节）。修改InsertSortApp.java中的insertionSort()方法，使它可以在排序过程中
 * 删除相同的数据项。方法如下：当找到一个重复数据项的时候，通常用一个小于任何值得关键值来
 * 改写这个相同数据项（如果所有值都是正数，则可取-1）。于是，一般的插入排序算法就会像处理
 * 其他数据项一样，来处理这个修改了关键值得数据项，把它移到下标为1的位置，依次类推。排序
 * 完成后，所有相同的数据项（现在关键值为-1）都在数组的开头部分。可以改变数组的容量并把需
 * 要的数据前移到数组下标为0的位置。
 */
class ArrayIns4 {
    private long[] a;
    private int nElems;

    public ArrayIns4(int max) {
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

    //插入排序并删除重复数据项
    public void insertionSort_NoDups() {
        int in, out;
        int count = 0;//重复数据项个数
        long NULL = -1;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp && a[in - 1] != NULL) {
                if (a[in - 1] == temp) {
                    temp = NULL;
                    count++;
                }
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }

        System.out.println("将重复元素置为-1后：");
        display();

        nElems -= count;//将重复数据项去除之后的数组大小
        for (int i = 0; i < nElems; i++) {
            a[i] = a[i + count];//把排好序的元素向前移动count个位置
        }
    }
}

public class Ex3_6 {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns4 arr;
        arr = new ArrayIns4(maxSize);

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

        arr.insertionSort_NoDups();
        arr.display();
    }
}
/**
 * output:
 * 77 99 77 77 99 44 55 44 55 55 22 88 88 22 88 11 0 66 11 33 33 66 33 33 0
 * 将重复元素置为-1后：
 * -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 0 11 22 33 44 55 66 77 88 99
 * 0 11 22 33 44 55 66 77 88 99
 */