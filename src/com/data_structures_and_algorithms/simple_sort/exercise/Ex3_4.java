package com.data_structures_and_algorithms.simple_sort.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/28
 * @description: page 79
 * 练习3.4：还有一种简单排序算法是奇偶排序。它的思路是在数组中重复两趟。第一趟扫描选择
 * 所有的数据项对，a[j]和a[j+1],j是奇数（j=1，3，5，......）。如果它们的关键字的值次序
 * 颠倒，就交换它们。第二趟扫描对所有的偶数数据项进行同样的操作（j=2,4,6，......）。重复
 * 进行这样两趟的排序直到数组全部有序。用oddEvenSort()方法替换bubbleSort.java程序（清单
 * 3.1）中的bubbleSort方法。确保它可以在不同数据量的排序中运行，还需要算出两趟扫描的次数。
 * 奇偶排序实际上在多处理器环境中很有用，处理器可以分别同时处理每一个奇数对，然后又同的
 * 处理偶数对。因为奇数对是彼此独立的，每一对都可以用不同的处理器比较和交换。这样可以非常
 * 快速地排序。
 */
class ArrayBub2 {
    private long[] a;
    private int nElems;

    public ArrayBub2(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    //省略delete find ...

    /**
     * 奇偶排序（以从小到大的排序为例）：
     * 举例：现有数组元素有 5,3,2,7,8,6
     * <p>
     * 第一趟外循环（以下标来定奇偶数对）：
     * 偶数对排序>  (5,3) -> (3,5)
     * (2,7) -> (2,7) //次序未颠倒，不移动。
     * (8,6) -> (6,8)
     * -> 3,5,2,7,6,8
     * 奇数对排序>  (5,2) -> (2,5)
     * (7,6) -> (6,7)
     * -> 3,2,5,6,7,8
     * 第二趟外循环：
     * 偶数对排序> (3,2) -> (2,3)
     * (5,6) -> (5,6) //不移动
     * (7,8) -> (7,8) //不移动
     * -> 2,3,5,6,7,8 //结束
     */
    public void oddEvenSort() {
        boolean change = true;//定义标记：标记在奇数对、偶数对排序时发生元素交换的标记。
        int oddCount = 0;//奇数对排序扫描次数计数
        int evenCount = 0;//偶数对排序扫描次数计数
        while (change) {
            change = false;//若奇数对排序和偶数对排序没有元素颠倒则标记为false，则跳出循环。

            //偶数对排序
            for (int i = 0; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    long temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    change = true;
                }
            }
            evenCount++;

            //奇数对排序
            for (int i = 1; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    long temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    change = true;
                }
            }
            oddCount++;
        }
        System.out.print("oddCount: " + oddCount +"  ");
        System.out.println("evenCount: " + evenCount);
    }

}

public class Ex3_4 {
    public static void main(String[] args) {
        int maxSize = 100;
        System.out.println("数组元素个数为偶数:");
        ArrayBub2 arr;
        arr = new ArrayBub2(maxSize);

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

        arr.oddEvenSort();
        arr.display();

        System.out.println("----------------------------");

        System.out.println("数组元素个数为奇数:");
        ArrayBub2 arr2;
        arr2 = new ArrayBub2(maxSize);

        arr2.insert(77);
        arr2.insert(99);
        arr2.insert(44);
        arr2.insert(55);
        arr2.insert(22);
        arr2.insert(88);
        arr2.insert(11);
        arr2.insert(00);
        arr2.insert(66);
        arr2.display();

        arr2.oddEvenSort();
        arr2.display();
    }
}
/**output:
 * 数组元素个数为偶数:
 * 77 99 44 55 22 88 11 0 66 33
 * oddCount: 6  evenCount: 6
 * 0 11 22 33 44 55 66 77 88 99
 * ----------------------------
 * 数组元素个数为奇数:
 * 77 99 44 55 22 88 11 0 66
 * oddCount: 5  evenCount: 5
 * 0 11 22 44 55 66 77 88 99
 */