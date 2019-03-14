package com.thinkinginjava.io.exercise.chapter18_10;

import com.thinkinginjava.io.example.chapter18_10.ex18_10_2.IntBufferDemo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description: page 559
 * 练习24：将{@link IntBufferDemo}修改成实用double。
 */
public class Ex24 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer ib = bb.asDoubleBuffer();

        // 存储一个int数组
        ib.put(new double[] {11, 42, 47, 99, 142, 811, 1016});
        // 在绝对位置上读写
        System.out.println(ib.get(3));
        ib.put(3, 1811);

        //在rewind缓冲区之前设置新限制
        ib.flip();
        while (ib.hasRemaining()) {
            double i = ib.get();
            System.out.print(i + " ");
        }
    }
}
/**output:
 * 99.0
 * 11.0 42.0 47.0 1811.0 142.0 811.0 1016.0
 */