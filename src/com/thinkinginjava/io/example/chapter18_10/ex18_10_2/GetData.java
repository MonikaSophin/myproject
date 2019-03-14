package com.thinkinginjava.io.example.chapter18_10.ex18_10_2;

import java.nio.ByteBuffer;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // allocate()自动将ByteBuffer归零:
        int i = 0;
        while(i++ < bb.limit())
            if(bb.get() != 0)
                print("nonzero");
        print("i = " + i);
        bb.rewind();

        // 存储和读取char数组:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar()) != 0)
            printnb(c + " ");
        print();
        bb.rewind();

        // 存储和读取 short:
        bb.asShortBuffer().put((short)471142);
        print(bb.getShort());
        bb.rewind();

        // 存储和读取 int:
        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();

        // 存储和读取 long:
        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();

        // 存储和读取 float:
        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();

        // 存储和读取 double:
        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }
}
/**output:
 * i = 1025
 * H o w d y !
 * 12390
 * 99471142
 * 99471142
 * 9.9471144E7
 * 9.9471142E7
 */