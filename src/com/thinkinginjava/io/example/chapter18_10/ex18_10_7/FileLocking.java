package com.thinkinginjava.io.example.chapter18_10.ex18_10_7;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/15
 * @description:
 */
public class FileLocking {
    public static void main(String[] args) throws Exception {
        String filepath = "src\\com\\thinkinginjava\\io\\example\\chapter18_10\\file\\FileLocking.txt";
        FileOutputStream fos = new FileOutputStream(filepath);

        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            /**
             * {@link FileLock#release()}：释放这个锁
             */
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
/**output:
 * Locked File
 * Released Lock
 */