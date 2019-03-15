package com.thinkinginjava.io.example.chapter18_10.ex18_10_7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/15
 * @description:
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF;// 128 MB
    static FileChannel fc;
    public static void main(String[] args) throws Exception {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_10\\file\\LockingMappedFiles.txt";
        fc = new RandomAccessFile(filePath, "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0 ,LENGTH);
        for (int i = 0; i < LENGTH; i++)
            out.put((byte)'x');
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        public LockAndModify(ByteBuffer buff, int start, int end) {
            this.start = start;
            this.end = end;
            buff.position(start);
            buff.limit(end);
            /**
             * {@link ByteBuffer#slice()}:创建一个新的字节缓冲区，其内容是此缓冲区内容的共享子序列。
             */
            this.buff = buff.slice();
            start();
        }

        @Override
        public void run() {
            try {
                /**
                 * {@link FileChannel#lock(long, long, boolean)}:
                 * 第一参数：表示从什么位置开始加锁。
                 * 第二参数：表示加锁的区域大小。
                 * 第三参数：指定是否是共享锁。
                 */
                FileLock fl = fc.lock(start, end, false);
                System.out.println(String.format("Locked: %s to %s", start, end));
                while (buff.position() < buff.limit() - 1)
                    buff.put((byte) (buff.get() + 1));
                fl.release();
                System.out.println(String.format("Released: %s to %s", start, end));
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
