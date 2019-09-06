package com.monika.io.sequence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author XueYing.Cao
 * @date 2019/9/6
 * 类作用：SequenceInputStream表示其他输入流的逻辑级联。
 * 它从一个有序的输入流集合开始，从第一个读取到文件的结尾，然后从第二个文件读取，依此类推，直到最后一个输入流达到文件的结尾。
 * 序列流：SequenceInputStream
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String fileName1 = "D:/GithubRepository/myproject/src/com/monika/io/sequence/file1";
        String fileName2 = "D:/GithubRepository/myproject/src/com/monika/io/sequence/file2";
        String fileName3 = "D:/GithubRepository/myproject/src/com/monika/io/sequence/file3";

        FileInputStream fis1 = new FileInputStream(fileName1);// 文件内容为'hello world! ||'
        FileInputStream fis2 = new FileInputStream(fileName2);// 文件内容为'  aa bb cc ||'
        FileInputStream fis3 = new FileInputStream(fileName3);// 文件内容为'  alex bob'

        // 将3个InputStream用SequenceInputStream合并成一个InputStream
        Enumeration enumerations;
        Vector<FileInputStream> vector = new Vector<>();
        vector.add(fis1);
        vector.add(fis2);
        vector.add(fis3);
        enumerations = vector.elements();
        SequenceInputStream sis = new SequenceInputStream(enumerations);

        int c;
        while ((c = sis.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
/**output:
 * hello world! ||  aa bb cc ||  alex bob
 */