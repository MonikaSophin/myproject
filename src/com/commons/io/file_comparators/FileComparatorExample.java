package com.commons.io.file_comparators;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @author XueYing.Cao
 * @date 2019/9/11
 */
public class FileComparatorExample {

    public static void main(String[] args) {

        //该文件夹下共有4个对象
        //  directory  comparator       无内容
        //	file       comparator1.txt  内容： a b c d
        //	file       comparator2.txt  无内容
        //	file       exampleTxt.txt   内容： a b c
        String dirPath = "D:/GithubRepository/myproject/src/com/commons/io/file_comparators/src/";
        File dirFile = FileUtils.getFile(dirPath);

        /**
         * 1. NameFileComparator : 按照文件名进行自然排序
         */
        NameFileComparator comparator1 = new NameFileComparator();
        File[] sortNameFiles = comparator1.sort(dirFile.listFiles());
        System.out.println("NameFileComparator: ");
        Arrays.stream(Objects.requireNonNull(sortNameFiles)).forEach(e -> System.out.println("\t" + e));

        /**
         * 2. SizeFileComparator : 按照文件内容大小进行排序
         * true：表示文件夹里的内容也计大小
         * false ： 表示文件夹大小直接计为0
         */
        SizeFileComparator comparator2 = new SizeFileComparator(true);
        File[] sortSizeFiles = comparator2.sort(dirFile.listFiles());
        System.out.println("SizeFileComparator: ");
        Arrays.stream(Objects.requireNonNull(sortSizeFiles)).forEach(e -> System.out.println("\t" + e));

        /**
         * 3. LastModifiedFileComparator : 按照文件最后修改时间进行排序
         */
        LastModifiedFileComparator comparator3 = new LastModifiedFileComparator();
        File[] sortLMFiles = comparator3.sort(dirFile.listFiles());
        System.out.println("LastModifiedFileComparator: ");
        Arrays.stream(Objects.requireNonNull(sortLMFiles)).forEach(e -> System.out.println("\t" + e +"\t" + new Date(e.lastModified())));

    }
}
/**output:
 * NameFileComparator:
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator1.txt
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator2.txt
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\exampleTxt.txt
 * SizeFileComparator:
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator2.txt
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\exampleTxt.txt
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator1.txt
 * LastModifiedFileComparator:
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator2.txt	Tue Sep 10 16:51:04 CST 2019
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator	Wed Sep 11 16:21:26 CST 2019
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\comparator1.txt	Wed Sep 11 16:26:41 CST 2019
 * 	D:\GithubRepository\myproject\src\com\commons\io\file_comparators\src\exampleTxt.txt	Wed Sep 11 16:26:47 CST 2019
 */