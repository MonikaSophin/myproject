package com.data_structures_and_algorithms.recursion.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/25
 * @description: 清单 6.3 使用递归进行二分查找
 * {@link com.data_structures_and_algorithms.array.example.OrderArray#find(long)}
 */
class OrdArray {
    private long[] a;
    private int nElems;
    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() { return nElems; }
    public int find(long searchKey) { return recFind(searchKey, 0, nElems - 1); }
    public int recFind(long searchKey, int lowerBound, int upperBound) {
        int midddle = (lowerBound + upperBound)/2;
        System.out.println("middle = " + midddle);
        if (a[midddle] == searchKey)
            return midddle;
        else if (lowerBound > upperBound)
            return -1;//未找到
        else {
            if (a[midddle] > searchKey)
                return recFind(searchKey, lowerBound, midddle - 1);
            else
                return recFind(searchKey, midddle + 1, upperBound);
        }
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
    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(727);
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);
        arr.display();

        int searchKey = 27;
        if (arr.find(searchKey) != -1)
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
    }
}
/**output:
 * 9 18 27 36 45 54 63 81 90 99 108 117 126 135 144 727
 * middle = 7
 * middle = 3
 * middle = 1
 * middle = 2
 * Found 27
 */