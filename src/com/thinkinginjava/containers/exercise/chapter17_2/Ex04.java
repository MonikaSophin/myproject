package com.thinkinginjava.containers.exercise.chapter17_2;

import com.thinkinginjava.util.TextFile;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

/**
 * @Author: monika
 * @Date: 2019/2/24 20:12
 * @Version: 1.0
 * @Description: page 470
 * 练习04：创建一个Collection初始化器，它将打开一个文件，并用TextFile将其断开为单词，
 * 然后将这些单词作为所产生的Collection的数据源使用。请演示它是可以工作的。
 */
public class Ex04 {
    static Collection<String> CollectFromText(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return Arrays.asList(sa);
    }
    static Collection<String> CollectFromText2(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return new TreeSet<>(new TextFile(fileName, "\\W+"));
    }

    public static void main(String[] args) {
        System.out.println(CollectFromText("src\\com\\thinkinginjava\\containers\\exercise\\chapter17_2\\Ex04.java"));
        System.out.println();
        System.out.println(CollectFromText2("src\\com\\thinkinginjava\\containers\\exercise\\chapter17_2\\Ex04.java"));
    }
}
//output:
//[package, com.thinkinginjava.containers.exercise.chapter17_2;
//
//        import, com.thinkinginjava.util.TextFile;
//        import, java.util.Arrays;
//        import, java.util.Collection;
//        import, java.util.TreeSet;
//
///**
// , *, @Author:, monika
// , *, @Date:, 2019/2/24, 20:12
// , *, @Version:, 1.0
// , *, @Description:, page, 470
// , *, 练习04：创建一个Collection初始化器，它将打开一个文件，并用TextFile将其断开为单词，
// , *, 然后将这些单词作为所产生的Collection的数据源使用。请演示它是可以工作的。
// , */
//public, class, Ex04, {
//        , , , , static, Collection<String>, CollectFromText(String, fileName), {
//        , , , , , , , , String[], sa, =, TextFile.read(fileName).split(", ");
//        , , , , , , , , return, Arrays.asList(sa);
//        , , , , }
//        , , , , static, Collection<String>, CollectFromText2(String, fileName), {
//        , , , , , , , , String[], sa, =, TextFile.read(fileName).split(", ");
//        , , , , , , , , return, new, TreeSet<>(new, TextFile(fileName,, "\\W+"));
//        , , , , }
//
//        , , , , public, static, void, main(String[], args), {
//        , , , , , , , , System.out.println(CollectFromText("src\\com\\thinkinginjava\\containers\\exercise\\chapter17_2\\Ex04.java"));
//        , , , , , , , , System.out.println();
//        , , , , , , , , System.out.println(CollectFromText2("src\\com\\thinkinginjava\\containers\\exercise\\chapter17_2\\Ex04.java"));
//        , , , , }
//        }
//
//        ]
//
//        [0, 04, 1, 12, 2, 20, 2019, 24, 470, Arrays, Author, CollectFromText, CollectFromText2, Collection, Date, Description, Ex04, String, System, TextFile, TreeSet, Version, W, args, asList, chapter17_2, class, com, containers, exercise, fileName, import, java, main, monika, new, out, package, page, println, public, read, return, sa, split, src, static, thinkinginjava, util, void]
//
