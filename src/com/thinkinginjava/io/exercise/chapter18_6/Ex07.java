package com.thinkinginjava.io.exercise.chapter18_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/11
 * @description: page 540
 * 练习07：打开一个文本文件，每次读取一行内容。将每行作为一个String读入，并将那个
 * String对象置入一个LinkedList中。按相反的顺序打印出LinkedList中的所有行。
 */
public class Ex07 {
    public static LinkedList<String> read(String filename) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(filename));
        LinkedList<String> list = new LinkedList<>();
        String s;
        while((s = br.readLine()) != null)
            list.addFirst(s);
        return list;
    }

    public static void main(String[] args) throws IOException {
        LinkedList<String> list = read(
                "src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\Ex07.java");
        for (String s : list)
            System.out.println(s);
    }
}
//output:
//}
//        }
//        System.out.println(s);
//        for (String s : list)
//        "src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\Ex07.java");
//        LinkedList<String> list = read(
//public static void main(String[] args) throws IOException {
//
//        }
//        return list;
//        list.addFirst(s);
//        while((s = br.readLine()) != null)
//        String s;
//        LinkedList<String> list = new LinkedList<>();
//        new FileReader(filename));
//        BufferedReader br = new BufferedReader(
//public static LinkedList<String> read(String filename) throws IOException {
//public class Ex07 {
// */
//         * String对象置入一个LinkedList中。按相反的顺序打印出LinkedList中的所有行。
//            * 练习07：打开一个文本文件，每次读取一行内容。将每行作为一个String读入，并将那个
// * @description: page 540
//            * @date: 2019/3/11
//            * @author: XueYing.Cao
///**
//
// import java.util.LinkedList;
// import java.io.IOException;
// import java.io.FileReader;
// import java.io.BufferedReader;
//
// package com.thinkinginjava.io.exercise.chapter18_6;
