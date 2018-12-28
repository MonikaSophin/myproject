package com.data_structures_and_algorithms.simple_sort.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/26
 * @description: page 78
 * 练习3.1：BubbleSortApp.java程序（清单3.1）和BubbleSort专题applet中，in索引变量都是从左到右移动的，
 * 直到找到最大数据项并把它移动到右边的out变量处。修改bubbleSort()方法，使它成为双向移动的。这样，in索引
 * 先像以前一样，将最大的数据项从左移到右，当它到达out变量位置时，它掉头并把最小的数据项从右移到左。需要
 * 两个外部索引变量，一个在右边（以前的out变量），另一个在左边。
 */
class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
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
     * 冒泡排序(双向移动：较大数从左往右移动，较小数从右往左移动。外循环次数减半。)
     * 举例，假设数组元素为10个。
     * 第一趟外循环，找出最小数和最大数，分别置于'0'和'9'位置。
     * 往右移动找出最大数：比较次数为9，涉及范围为0->9
     * 往左移动找出最小数：比较次数为8，涉及范围为8->0
     * 第二趟外循环，找出第二最小数和第二最大数，分别置于'1'和'8'位置。
     * 往右移动找出最大数：比较次数为7，涉及范围为1->8
     * 往左移动找出最小数：比较次数为6，涉及范围为7->1
     * ...
     * <p>
     * <p>
     * 所以为了算法最优化，减少向左移动和向右移动的比较次数（注意：总的比较次数与正常的往右移动的冒泡排序一样）。
     */
    //方法一：
    public void bubbleSort() {
        int out, in;
        int count = 0;//比较次数计数
        for (out = 0; out < nElems / 2; out++) {//外循环次数减半
            //往右移动。 0->9、1->8、2->7、3->6、4->5(找出最大值依次置于下标9、8、7、6、5)
            for (in = out; in < nElems - out - 1; in++) {
                if (a[in] > a[in + 1]) {
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
                count++;
            }
            //往左移动。 8->0、7->1、6->2、5->3、4->4(找出最小值依次置于下标0、1、2、3、4)
            for (in = in - 1; in > out; in--) {//in > out的作用：跟上面的循环in < nElems - out -1;的作用一样，减少比较次数。
                if (a[in] < a[in - 1]) {
                    long temp = a[in];
                    a[in] = a[in - 1];
                    a[in - 1] = temp;
                }
                count++;
            }
        }
        System.out.println("总的比较次数： " + count);
    }

    //方法二：
    public void bubbleSort1() {
        int leftout = 0, rightout = nElems - 1, in; // leftout,rightout为左右两端指针
        for (; rightout > leftout; rightout--, leftout++) {
            //往右移动。 0->9、1->8、2->7、3->6、4->5(找出最大值依次置于下标9、8、7、6、5)
            for (in = leftout; in < rightout; in++) {
                if (a[in] > a[in + 1]) {
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
            //往左移动。 8->0、7->1、6->2、5->3、4->4(找出最小值依次置于下标0、1、2、3、4)
            for (in = rightout - 1; in > leftout; in--) {
                if (a[in] < a[in - 1]) {
                    long temp = a[in];
                    a[in] = a[in - 1];
                    a[in - 1] = temp;
                }
            }
        }
    }

}

public class Ex3_1 {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

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

        arr.bubbleSort();
        arr.display();
    }
}
/**
 * output:
 * 77 99 44 55 22 88 11 0 66 33
 * 总的比较次数： 45
 * 0 11 22 33 44 55 66 77 88 99
 */