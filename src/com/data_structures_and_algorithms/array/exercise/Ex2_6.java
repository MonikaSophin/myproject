package com.data_structures_and_algorithms.array.exercise;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/21
 * @description: page 50
 * 练习2.6：向HighArray.java程序（清单2.3）的HighArray类中加入一个noDup()的方法，使之可以
 * 将数组中的所有重复数据项删除。即如果数组中有三个数据项的关键字为17，noDups()方法会删除其中
 * 的两个。不必考虑保持数据项的顺序。一种方法是先用每一个数据项用其他数据项比较，并用null（或是
 * 一个不会用在真正的关键字中的特殊值）将重复的数据项覆盖掉。然后将所有的null删除，当然还要缩小
 * 数组的大小。
 */
class HighArray4 {
    private int[] a;
    private int nElems;

    public HighArray4(int max) {
        a = new int[max];
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

    public void insert(int value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(int value) {
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

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * 方法一：
     * 思路 找出重复的元素，并赋值为NULL
     * 在去除重复元素时，进行覆盖NULL元素需要注意出现连续为NULL元素的情况。
     */
    public void noDup() {
        int NULL = -1;//重复元素的标识
        for (int i = 0; i < nElems; i++)
            for (int j = i + 1; j < nElems; j++)
                if (a[i] != NULL && a[i] == a[j])
                    a[j] = NULL;

        for (int i = 0; i < nElems; ) {
            if (a[i] == NULL) {//移动完成后没有进行i++,而是继续判断移动后的当前位置元素是否为NULL
                for (int j = i; j < nElems; j++)
                    a[j] = a[j + 1];
                nElems--;
            } else {
                i++;//若不为NULL，则直接i++
            }
        }
    }

    /**
     * 方法二：
     * 思路： 将不是NULL的元素，直接移动a[0]、a[1]、a[3]...以此类推。
     *    类似一种临时缓冲数组的思路。 只不过使用的是同一个数组，将满足条件的数组元素进行缓冲。
     */
    public void noDup2() {
        int NULL = -1;
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++)
                if (a[i] != NULL && a[i] == a[j])
                    a[j] = NULL;
        }

        int temp = 0;//临时数组下标
        for (int i = 0; i < nElems; i++) {
            if (a[i] != NULL) {
                a[temp] = a[i];
                temp++;
                // =等价于=>
                // a[temp++] = a[i];
            }
        }
        nElems = temp;//将不为NULL的元素个数 赋值给 全局变量nElems。
    }
}

public class Ex2_6 {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray4 arr;
        arr = new HighArray4(maxSize);

        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(3) + 1;
            arr.insert(i1);
        }
        arr.display();

        arr.noDup2();
        arr.display();
    }
}
/**输出：
 * 3 3 2 3 2 3 2 3 1 2
 * 3 2 1
 */