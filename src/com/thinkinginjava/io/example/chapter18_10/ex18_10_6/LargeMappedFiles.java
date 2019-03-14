package com.thinkinginjava.io.example.chapter18_10.ex18_10_6;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF; // 128MB

    public static void main(String[] args) throws Exception {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_10\\file\\LargeMappedFiles.txt";
        MappedByteBuffer out = new RandomAccessFile(filePath, "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++)
            out.put((byte)'x');
        print("Finished writing");
        for (int i = length/2; i < length/2 + 6; i++)
            printnb((char)out.get(i));
    }
}
/**output:
 * Finished writing
 * xxxxxx
 */