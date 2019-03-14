package com.thinkinginjava.io.example.chapter18_10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        /**
         * {@link ByteBuffer#flip()} : 向ByteBuffer存储字节是，就必须要调用缓冲器上的filp()
         *                           来为每个write()做好准备。
         * {@link ByteBuffer#clear()} : 如果打算使用缓冲器执行进一步的read()操作，必须调用clear()
         *                            来为每个read()做好准备。
         */
        while (in.read(buffer) != -1) {
            buffer.flip(); //准备‘写’
            out.write(buffer);
            buffer.clear(); //准备‘读’
        }
        /**
         * 拷贝数据可以参考{@link TransferTo}
         */
    }
}
/**output:
 * 略~
 */
