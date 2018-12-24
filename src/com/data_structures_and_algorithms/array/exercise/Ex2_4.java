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

    /**
     * 使用二分查找算法插入值时（以从小到大的顺序来说明），
     * 令数组为a，长度为length，插入值为insert，中间值下标m
     * 当 insert==a[m] 插入到下标m位置。
     * 当 a[0]<=insert<a[m]
     *       若m==0，插入到下标'0'位置。
     *       若中间值下标'm'没有移动到'0'位置，则需要确定 a[m-1]<=insert<a[m] 才能将inert插入到下标'm'位置。
     *       否则，再次二分
     * 当 a[m]<insert<=a[length-1]
     *       若m==length-1，则认为插入值大于现有数组最大值，插入到下标'm+1'位置。
     *       若中间值下标'm'没有移动到'length-1'位置,则需要确定 a[m]<insert<=a[m+1] 才能将insert插入到下标'm+1'位置。
     *       否则，再次二分
     */
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
                    upperBound = middle - 1;
                else
                    lowerBound = middle + 1;
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

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
/**输出：
 * 0 11 22 33 44 55 66 77 88 99
 * 11 22 33 44 66 77 88
 */
