package com.data_structures_and_algorithms.array.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/21
 * @description: page 50
 * 练习2.5:向OrderedArray.java程序（清单2.4）的OrdArray类加入一个merge()方法，使之可以将
 * 两个有序的源数组组合合并成一个有序的目的数组。在main()中添加代码，向两个源数组中插入随机数，
 * 调用merge()方法，并将结果目的数组显示出来。两个源数组的数据项个数可能不同。在算法中需要
 * 先比较原数组中的关键字，从中选出最小的一个数据项复制到目的数组。同时还要考虑如何解决当一个
 * 源数组的数据项已经取完二另一个还剩一些数据项的情况。
 */
class OrderArray2 {
    private long[] a;
    private int nElems;//最大可存储的元素个数

    public OrderArray2(int maxSize) {
        a = new long[maxSize];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--) //比待插入值大的数值向后移动
            a[k] = a[k - 1];
        a[j] = value;
        nElems++;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;

        int middle;//每次二分查找范围时，中间的下标。
        while (true) {
            middle = (lowerBound + upperBound) / 2;
            if (a[middle] == searchKey)
                return middle;
            else if (lowerBound > upperBound)//若范围缩小到最小值比最大值还大，则查找不到该值。
                return -1;
            else {
                if (a[middle] > searchKey)
                    upperBound = middle -1;
                else
                    lowerBound = middle +1;
            }
        }
    }

    public boolean delete(long value) {
        int index = find(value);
        if (index == -1) {
            return false;
        } else {
            for (int k = index; k < nElems; k++)
                a[k] = a[k + 1];
            nElems --;
            return true;
        }
    }
    
    public static int[] merge(int[] a ,int[] b){
        if (a.length >= b.length){
            for (int i = 0; i < b.length; i++) {
                // TODO: 2018/12/21  
            }
        }
        return null;
    }

    public void display(){
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
public class Ex2_5 {
}
