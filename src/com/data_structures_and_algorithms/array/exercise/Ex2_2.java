package com.data_structures_and_algorithms.array.exercise;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/18
 * @description: page 50
 * 练习2.2：修改编程作业2.1中的方法，使之不仅返回最大的关键字，而且还将该关键字从数组中删除。
 * 将这个方法命名为removeMax()。
 */
class HighArray2 {
    private long[] a;
    private int nElems;

    public HighArray2(int max) {
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
    public long removeMax(){
        if (nElems == 0)
            return -1;
        else{
            long max = -1;//设置最大值
            int index = -1;//设置最大值下标
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max){
                    max = a[i];
                    index = i;
                }
            }
            for (int k = index; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return max;
        }
    }

    //解法2：
    public long removeMax2() {
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
}

public class Ex2_2 {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray2 arr;
        arr = new HighArray2(maxSize);

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
        System.out.println("removeMax() " + arr.removeMax());
        arr.display();
        System.out.println();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
        System.out.println("removeMax() " + arr.removeMax());
        arr.display();
    }
}
/**
 * 输出：
 * 77 99 44 55 22 88 11 0 66 33
 * removeMax() 99
 * 77 44 55 22 88 11 0 66 33
 *
 * 77 44 22 88 11 66 33
 * removeMax() 88
 * 77 44 22 11 66 33
 */