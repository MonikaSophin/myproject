package com.monika.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author XueYing.Cao
 * @date 2019/9/16
 * <p>
 * {@link java.nio.Buffer}的示例，方便起见，使用FileChannel
 */
public class BufferExample {

    public static void main(String[] args) {
        String fileInName = "D:/GithubRepository/myproject/src/com/monika/nio/buffer/test";
        try (
                RandomAccessFile file = new RandomAccessFile(fileInName, "rw");
                FileChannel channel = file.getChannel() //获取FileChannel
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(128); //分配capacity给Buffer
            int readSize = channel.read(buffer); //channel-->Buffer。此时，position=readsize, limit=capacity=128
            while (readSize != -1) {
                buffer.flip(); //Buffer切换为read模式，为channel-write/buffer-get准备一个缓冲区。此时，limit=position,position=0,capacity=128
                while (buffer.hasRemaining()) { // remaining=limit-position
                    System.out.print((char) buffer.get());
                }
                buffer.clear();//Buffer切换为write模式，为channel-read/buffer-put准备一个缓冲区。此时，position=0，limit=capacity=128
                readSize = channel.read(buffer);//channel-->Buffer。
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
