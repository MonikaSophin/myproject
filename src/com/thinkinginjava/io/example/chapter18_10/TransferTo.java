package com.thinkinginjava.io.example.chapter18_10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class TransferTo {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0, in.size(), out);
        //或者如下形式：
        // out.transferFrom(in, 0, in.size());
    }
}
/**output:
 * 略~
 */