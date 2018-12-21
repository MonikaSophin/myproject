package com.data_structures_and_algorithms.array.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/12
 * @description: page 28
 * 清单2.3 --HighArray接口
 */
class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
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

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

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

        int searchkey = 35;
        if (arr.find(searchkey))
            System.out.println("Found " + searchkey);
        else
            System.out.println("Can't find " + searchkey);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
/**
 * 输出：
 * 77 99 44 55 22 88 11 0 66 33
 * Can't find 35
 * 77 44 22 88 11 66 33
 */