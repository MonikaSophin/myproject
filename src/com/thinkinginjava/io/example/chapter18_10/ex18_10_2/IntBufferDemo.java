package com.thinkinginjava.io.example.chapter18_10.ex18_10_2;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();

        // 存储一个int数组
        ib.put(new int[] {11, 42, 47, 99, 142, 811, 1016});
        // 在绝对位置上读写
        System.out.println(ib.get(3));
        ib.put(3, 1811);

        //在rewind缓冲区之前设置新限制
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.print(i + " ");
        }
    }
}
/**output:
 * 99
 * 11 42 47 1811 142 811 1016
 */