package com.data_structures_and_algorithms.array.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/6
 * @description: page 22
 * 清单2.1  --演示数组应用的例子
 */
public class ArrayApp {
    public static void main(String[] args) {
        long[] arr;
        arr = new long[100];
        int nElems = 0;
        int j;
        long searChkey;

        //插入数组元素
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;

        //遍历
        for (j = 0; j < nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println();

        //查找
        searChkey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searChkey)
                break;
        }
        if (j == nElems)
            System.out.println("Can't find " + searChkey);
        else
            System.out.println("Found " + searChkey);

        //删除
        searChkey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searChkey)//找到待删除的数组元素下标
                break;
        }
        for (int k = j; k < nElems; k++) {
            arr[k] = arr[k + 1];//将删除的数组元素下标开始，后面的元素one by one的代替前一个数组元素
        }
        nElems--;//缩短数组长度一位
        //查看删除之后的数组元素
        for (j = 0; j < nElems; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

}
