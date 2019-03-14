package com.thinkinginjava.io.exercise.chapter18_8;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 549
 * 练习21：写一个程序，它接受标准输入并将所有字符转换为大写，然后将结果写入到
 * 标准输出流中。将文件的内容重定向到该程序中（重定向的过程会根据操作系统的不同
 * 而有所变化）。
 */
public class Ex21 {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\com\\thinkinginjava\\io\\exercise\\chapter18_8\\Ex21.java");
        BufferedInputStream inFile =
                new BufferedInputStream(new
                        FileInputStream(file));
        System.setIn(inFile);

        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = stdin.readLine()) != null)
            System.out.println(s.toUpperCase());

    }
}
//output:
//PACKAGE COM.THINKINGINJAVA.IO.EXERCISE.CHAPTER18_8;
//
//IMPORT JAVA.IO.BUFFEREDINPUTSTREAM;
//IMPORT JAVA.IO.BUFFEREDREADER;
//IMPORT JAVA.IO.FILE;
//IMPORT JAVA.IO.FILEINPUTSTREAM;
//IMPORT JAVA.IO.IOEXCEPTION;
//IMPORT JAVA.IO.INPUTSTREAMREADER;
//
///**
// * @AUTHOR: XUEYING.CAO
// * @DATE: 2019/3/13
// * @DESCRIPTION: PAGE 549
// * 练习21：写一个程序，它接受标准输入并将所有字符转换为大写，然后将结果写入到
// * 标准输出流中。将文件的内容重定向到该程序中（重定向的过程会根据操作系统的不同
// * 而有所变化）。
// */
//PUBLIC CLASS EX21 {
//    PUBLIC STATIC VOID MAIN(STRING[] ARGS) THROWS IOEXCEPTION {
//        FILE FILE = NEW FILE("SRC\\COM\\THINKINGINJAVA\\IO\\EXERCISE\\CHAPTER18_8\\EX21.JAVA");
//        BUFFEREDINPUTSTREAM INFILE =
//                NEW BUFFEREDINPUTSTREAM(NEW
//                        FILEINPUTSTREAM(FILE));
//        SYSTEM.SETIN(INFILE);
//
//        BUFFEREDREADER STDIN = NEW BUFFEREDREADER(
//                NEW INPUTSTREAMREADER(SYSTEM.IN));
//        STRING S;
//        WHILE((S = STDIN.READLINE()) != NULL)
//            SYSTEM.OUT.PRINTLN(S.TOUPPERCASE());
//
//    }
//}
