package com.thinkinginjava.Initialize_clean.example.chapter5_5.ex5_5_3;

/**
 * @Author: monika
 * @Date: 2018/11/11 12:33
 * @Version: 1.0
 * @Description:  finalize()方法：会在垃圾回收前调用(前提是你在本类中覆写finalize)。
 *                               这个方法可以用来释放一些（非new创建的内存区域）。
 *                               可以在该方法内，使用本地方法来操作内存释放。
 *
 *
 *               对象可能不被垃圾回收。
 *               垃圾回收并不等于C++中的析构函数。
 *               垃圾回收只与内存有关。
 *               无论是gc()还是finalize()都不保证一定会发生。如果JVM并未面临内存耗尽的情形，
 *             它是不会浪费时间去执行垃圾回收以恢复内存的。所以不该将finalize()作为通用的清理方法。
 */
class Book {
    boolean checkedOut = false;
    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    void checkIn() {
        checkedOut = false;
    }
    @Override
    protected void finalize() {
        //super.finalize();
        if (checkedOut)
            System.out.println("Error: checked out");
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book book1 = new Book(true);
        book1.checkIn();
        new Book(true);
        System.gc();
    }
}
/**输出：
 * Error: checked out
 */
