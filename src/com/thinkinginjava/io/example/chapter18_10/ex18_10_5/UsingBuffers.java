package com.thinkinginjava.io.example.chapter18_10.ex18_10_5;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        /**
         * {@link ByteBuffer#hasRemaining()}
         * 等同于 {@link ByteBuffer#limit()} 减去 {@link ByteBuffer#position()}的值。
         */
        while (buffer.hasRemaining()) {
            /**
             * {@link ByteBuffer#mark()}:
             * 在此位置设置此缓冲区的标记。
             */
            buffer.mark();
            char c1 = buffer.get(); //position会移动一位
            char c2 = buffer.get(); //position会移动一位
            /**
             * {@link ByteBuffer#reset()}:
             * 将此缓冲区的位置重置为先前标记的位置。
             */
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        print(cb.rewind());

        symmetricScramble(cb);
        print(cb.rewind());

        symmetricScramble(cb);
        print(cb.rewind());
    }
}
/**output:
 * UsingBuffers
 * sUniBgfuefsr
 * UsingBuffers
 */