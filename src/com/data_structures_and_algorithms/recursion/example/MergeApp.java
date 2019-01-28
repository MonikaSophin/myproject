package com.data_structures_and_algorithms.recursion.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/25
 * @description: 清单 6.5 归并排序
 */
public class MergeApp {
    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[10];

        merge(arrayA, 4, arrayB, 6, arrayC);
        display(arrayC, 10);
    }

    private static void merge(int[] arrayA, int aSize, int[] arrayB, int bSize, int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;
        //数组A与数组B进行比较，数组A、B分配至数组C
        while (aDex < aSize && bDex < bSize){
            if (arrayA[aDex] < arrayB[bDex])
                arrayC[cDex++] = arrayA[aDex++];
            else
                arrayC[cDex++] = arrayB[bDex++];
        }
        //数组A与数组B比较结束，数组A、B分配至数组C，数组B为空，但数组A不为空。
        while (aDex < aSize)
            arrayC[cDex++] = arrayA[aDex++];
        //数组A与数组B比较结束，数组A、B分配至数组C，数组A为空，但数组B不为空。
        while (bDex < bSize)
            arrayC[cDex++] = arrayB[bDex++];
    }

    private static void display(int[] arrayC, int cSize) {
        for (int i = 0; i < cSize; i++)
            System.out.print(arrayC[i] + " ");
        System.out.println();
    }
}
/**output:
 * 7 14 23 39 47 55 62 74 81 95
 */