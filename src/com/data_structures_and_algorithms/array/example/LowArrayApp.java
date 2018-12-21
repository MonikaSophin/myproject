package com.data_structures_and_algorithms.array.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/6
 * @description: page 25
 * 清单2.2  --将清单2.1的例子划分成类
 */
class LowArray {
    private long[] a;

    public LowArray(int size) {
        a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) {
        return a[index];
    }
}

public class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;

        //更新
        arr.setElem(0, 77);
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10;

        //遍历
        for (j = 0; j < nElems; j++)
            System.out.print(arr.getElem(j) + " ");
        System.out.println();

        //查询
        int searchKey = 26;
        for (j = 0; j < nElems; j++)
            if (arr.getElem(j) == searchKey)
                break;
        if (j == nElems)
            System.out.println("Can't find " + searchKey);
        else
            System.out.println("Found " + searchKey);

        //查找到指定的元素，进行删除。
        for (j = 0; j < nElems; j++)
            if (arr.getElem(j) == 55)
                break;
        for (int k = j; k < nElems; k++)
            arr.setElem(k, arr.getElem(k + 1));
        nElems--;

        //遍历删除指定元素后的数组。
        for (j = 0; j < nElems; j++)
            System.out.print(arr.getElem(j) + " ");
        System.out.println();
    }
}
/**
 * 输出:
 * 77 99 44 55 22 88 11 0 66 33
 * Can't find 26
 * 77 99 44 22 88 11 0 66 33
 */