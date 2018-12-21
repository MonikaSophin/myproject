package com.data_structures_and_algorithms.array.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/18
 * @description: page 50
 * 练习2.4 修改orderArray.java程序（清单2.4）使insert()、delete()与find()方法一样都使用二分
 * 查找，正如书中所建议的那样。
 */
class OrderArray {
    private long[] a;
    private int nElems;//最大可存储的元素个数

    public OrderArray(int maxSize) {
        a = new long[maxSize];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;

        int middle;//每次二分查找范围时，中间的下标。
        while(true){
            middle = (lowerBound + upperBound) / 2;
            if (lowerBound >= upperBound)
                break;
            if (value >= a[middle])
                lowerBound = middle + 1;
            else
                upperBound = middle - 1;
        }
        for (int k = nElems; k > middle ; k--) //比待插入值大的数值向后移动
            a[k] = a[k - 1];
        a[middle] = value;
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
            for (int k = index; k < nElems; k++)//将删除后的空洞给填补上。
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
}

public class Ex2_4 {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderArray arr;
        arr = new OrderArray(maxSize);

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
        if(arr.find(searchkey) != -1)
            System.out.println("Found " +searchkey + " at index " + arr.find(searchkey));
        else
            System.out.println("Can't find " + searchkey);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
