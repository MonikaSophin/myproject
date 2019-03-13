package com.thinkinginjava.io.example.chapter18_6.ex18_6_6;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.DataInput;
import java.io.DataOutput;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 * {@link RandomAccessFile} 类似于组合使用了DataInputStream和DataOutputStream（
 * 因为它实现了相同的接口：{@link DataInput}和{@link DataOutput}）。
 * 可以使用{@link RandomAccessFile#seek(long)} 在文件中导出移动，并修改文件中的某个值。
 */
public class UsingRandomAccessFile {
    static String file = "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_6\\file\\rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++)
            System.out.println(String.format("Value %s: %s", i, rf.readDouble()));
        System.out.println(rf.readUTF());
        System.out.println();
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++)
            rf.writeDouble(i*1.414);
        rf.writeUTF("The end of the file");
        rf.close();

        display();

        rf = new RandomAccessFile(file, "rw");
        /**
         * double类型总是8字节长，所以使用了seek(5*8)查找
         * 第6个双精度值
         */
        rf.seek(5*8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
/**output:
 * Value 0: 0.0
 * Value 1: 1.414
 * Value 2: 2.828
 * Value 3: 4.242
 * Value 4: 5.656
 * Value 5: 7.069999999999999
 * Value 6: 8.484
 * The end of the file
 *
 * Value 0: 0.0
 * Value 1: 1.414
 * Value 2: 2.828
 * Value 3: 4.242
 * Value 4: 5.656
 * Value 5: 47.0001
 * Value 6: 8.484
 * The end of the file
 */