package com.thinkinginjava.io.example.chapter18_10.ex18_10_3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class Endians {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        print("默认的  : " + Arrays.toString(bb.array()));
        bb.rewind();

        /**
         * {@link ByteOrder.BIG_ENDIAN} ：
         * 高位优先，将最重要的字节存放在地址最低的存储单元。
         */
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        print("高位优先: " + Arrays.toString(bb.array()));
        bb.rewind();

        /**
         * {@link ByteOrder.LITTLE_ENDIAN} :
         * 低位优先，将最重要的字节存放在地址最高的存储单元。
         */
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        print("低位优先: " + Arrays.toString(bb.array()));
        bb.rewind();
    }
}
/**output:
 * 默认的  : [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * 高位优先: [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * 低位优先: [97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]
 *
 * 结论：一个字符占两个字节， 比如 a 是 97，以下用二进制表示:
 * 高位优先， 00000000 01100001
 * 低位优先， 01100001 00000000
 * 默认的是 高位优先。
 */