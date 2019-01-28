package com.data_structures_and_algorithms.recursion.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/28
 * @description: 清单 6.6 使用递归的归并排序
 */
class DArray {
    private long[] theArray;
    private int nElems;
    public DArray(int max) {
        theArray = new long[max];
        nElems = 0;
    }
    public void insert(long value) { theArray[nElems++] = value; }
    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(theArray[i] + " ");
        System.out.println();
    }
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }
    public void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int mid = (lowerBound + upperBound)/2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }
    public void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }
        while (lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while (highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        for (j = 0; j < n; j++)
            theArray[lowerBound++] = workSpace[j];
    }
}

public class MergeSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        DArray arr;
        arr = new DArray(maxSize);

        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(100);
        arr.insert(36);
        arr.display();

        arr.mergeSort();
        arr.display();
    }
}
/**output:
 * 64 21 33 70 12 85 44 3 99 0 100 36
 * 0 3 12 21 33 36 44 64 70 85 99 100
 */