package com.thinkinginjava.io.example.chapter18_10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 * {@link ByteBuffer}:唯一直接与通道交互的缓冲器。也就是说，可以存储为加工字节的缓冲器。
 * 旧的I/O类库有三个类被修改了，用以产生{@link FileChannel} :
 * {@link FileInputStream} {@link FileOutputStream} {@link RandomAccessFile}
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_10\\file\\GetChannel.txt";
        FileChannel fc = new FileOutputStream(filePath).getChannel();
        /**
         * {@link ByteBuffer#wrap(byte[])}:将字节数组包装到缓冲区中。
         */
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        //添加到文件的结尾
        fc = new RandomAccessFile(filePath, "rw").getChannel();
        fc.position(fc.size());//移动到结尾
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream(filePath).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();

        while (buff.hasRemaining())
            System.out.print((char) buff.get());
    }
}
/**output:
 * Some text Some more
 */