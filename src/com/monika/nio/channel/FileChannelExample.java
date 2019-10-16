package com.monika.nio.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author XueYing.Cao
 * @date 2019/10/14
 */
public class FileChannelExample {

    public static void main(String[] args) {
        String fileInName = "D:/GithubRepository/myproject/src/com/monika/nio/buffer/test";
        try (
                //打开FileChannel的两种方式，其一：RandomAccessFile
                FileChannel channel1 = new RandomAccessFile(fileInName, "rw").getChannel();
                //其二：InputStream、OutputStream
                FileChannel channel2 = new FileInputStream(fileInName).getChannel()
        ) {
            // 从fileChannel中读取数据
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            int read = channel1.read(buffer);

            // 向FileChannel中写入数据
            ByteBuffer buffer1 = ByteBuffer.allocate(48);
            buffer1.clear();
            buffer1.put("write to file channel".getBytes());

            buffer1.flip();
            while (buffer1.hasRemaining()) {
                channel1.write(buffer1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
