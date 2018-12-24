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
        if (nElems == 0) {//当数组内无元素时，直接插入
            a[nElems] = value;
            nElems++;
        } else {
            int lowerBound = 0;
            int upperBound = nElems - 1;

            int middle;//每次二分查找范围时，中间的下标。
            while (true) {
                middle = (lowerBound + upperBound) / 2;
                if (lowerBound > upperBound)
                    break;
                if (value == a[middle]){
                    break;
                }else if (value > a[middle]) {
                    if (middle == nElems - 1) {//若中间值到了最后一位
                        middle = middle + 1;
                        break;
                    } else if (value <= a[middle + 1]) { // a[middle]<插入值<=a[middle+1]
                        middle = middle + 1;
                        break;
                    } else {
                        lowerBound = middle + 1;
                    }
                }else{
                    if (middle == 0){//若中间值到了第一位
                        break;
                    }else if (value >= a[middle - 1]){ // a[middle-1]<=插入值<a[middle]
                        break;
                    }else {
                        upperBound = middle - 1;
                    }
                }
            }
            for (int k = nElems; k > middle; k--) //比待插入值大的数值向后移动
                a[k] = a[k - 1];
            a[middle] = value;
            nElems++;
        }
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

    public void display(){
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public OrderArray2 merge(OrderArray2 arr2){
        //假设数据项总是足够
        OrderArray2 dist = new OrderArray2(this.nElems + arr2.nElems); //目标的数组
        for (int i = 0; i < this.nElems; i++)
            dist.insert(this.a[i]);

        for (int i = 0; i < arr2.nElems; i++)
            dist.insert(arr2.a[i]);
        return dist;
    }
}

public class Ex2_5 {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderArray2 arr = new OrderArray2(maxSize);

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


        OrderArray2 arr2 = new OrderArray2(maxSize);
        arr2.insert(777);
        arr2.insert(999);
        arr2.insert(44);
        arr2.insert(555);
        arr2.insert(22);
        arr2.insert(888);
        arr2.insert(11);
        arr2.insert(00);
        arr2.insert(666);
        arr2.insert(33);
        arr2.display();

        OrderArray2 merge = arr.merge(arr2);
        merge.display();
    }
}
/**output:
 * 0 11 22 33 44 55 66 77 88 99
 * 0 11 22 33 44 555 666 777 888 999
 * 0 0 11 11 22 22 33 33 44 44 55 66 77 88 99 555 666 777 888 999
 */