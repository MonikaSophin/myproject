package com.thinkinginjava.io.exercise.chapter18_7;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.thinkinginjava.util.Directory;
import com.thinkinginjava.util.BinaryFile;
import com.thinkinginjava.util.Hex;

import static com.thinkinginjava.util.Directory.*;
import static com.thinkinginjava.util.BinaryFile.*;
import static com.thinkinginjava.util.Print.*;
/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 548
 * 练习20：用{@link Directory#walk(File, String)}和{@link BinaryFile}来验证
 * 在某个目录树下的所有的.class文件都是以十六进制字符'CAFEBABE'开头。
 */
public class Ex20 {
    public static void main(String[] args) throws IOException {
        List<File> files = walk(".", ".*\\.class").files;
        for(File file : files) {
            byte[] ba = read(file);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++)
                sb.append(Integer.toHexString(ba[i] & 0xff).toUpperCase() + " ");
            print(sb.toString());
            print();
        }
    }
}
/**output:
 * 略~
 */