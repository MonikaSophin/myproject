package com.commons.io.file_filter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author XueYing.Cao
 * @date 2019/9/10
 */
public class IOFileFilterExample {

    public static void main(String[] args) {

        //该文件夹下共有3个对象
        //  directory  example
        //	file       exampleEntry.txt
        //	file       exampleTxt.txt
        String dirPath = "D:/GithubRepository/myproject/src/com/commons/io/file_filter/src/";
        File file = FileUtils.getFile(dirPath);

        /**
         * 以下文件过滤器都间接地 实现了java.io的FileFilter, FilenameFilter
         *
         * 1. NameFileFilter : 按照文件名称 进行过滤
         */
        String[] accptFileNames = {"example", "exampleTxt.txt"};
        String[] list1 = file.list(new NameFileFilter(accptFileNames));
        System.out.println("NameFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list1)).forEach(e -> System.out.println("\t" + e));

        /**
         * 2. WildcardFileFilter : 按照给定通配符 进行过滤
         */
        String[] list2 = file.list(new WildcardFileFilter("*example*"));
        System.out.println("WildcardFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list2)).forEach(e -> System.out.println("\t" + e));

        /**
         * 3. PrefixFileFilter : 按照文件前缀 进行过滤
         */
        String[] list3 = file.list(new PrefixFileFilter("exam"));
        System.out.println("PrefixFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list3)).forEach(e -> System.out.println("\t" + e));

        /**
         * 4. SuffixFileFilter : 按照文件名后缀 进行过滤
         */
        String[] list4 = file.list(new SuffixFileFilter(".txt"));
        System.out.println("SuffixFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list4)).forEach(e -> System.out.println("\t" + e));

        /**
         * 5. AndFileFilter : 将两个文件过滤器'&'运算之后， 进行过滤
         */
        String[] list5 = file.list(new AndFileFilter(new PrefixFileFilter("exampleT"), new SuffixFileFilter(".txt")));
        System.out.println("AndFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list5)).forEach(e -> System.out.println("\t" + e));

        /**
         * 6. OrFileFilter : 将两个文件过滤器'|'运算之后， 进行过滤
         */
        String[] list6 = file.list(new OrFileFilter(new PrefixFileFilter("exampleT"), new SuffixFileFilter(".txt")));
        System.out.println("OrFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list6)).forEach(e -> System.out.println("\t" + e));

        /**
         * 7. EmptyFileFilter : 按照文件/文件夹的内容是空(非空) 进行过滤
         */
        String[] list7 = file.list(EmptyFileFilter.EMPTY); // file.list(EmptyFileFilter.NOT_EMPTY);
        System.out.println("EmptyFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list7)).forEach(e -> System.out.println("\t" + e));

        /**
         * 8. DirectoryFileFilter : 按照是否是文件夹 进行过滤
         */
        String[] list8 = file.list(DirectoryFileFilter.DIRECTORY);
        System.out.println("DirectoryFileFilter: ");
        Arrays.stream(Objects.requireNonNull(list8)).forEach(e -> System.out.println("\t" + e));
    }
}
/**output:
 * NameFileFilter:
 * 	example
 * 	exampleTxt.txt
 * WildcardFileFilter:
 * 	example
 * 	exampleEntry.txt
 * 	exampleTxt.txt
 * PrefixFileFilter:
 * 	example
 * 	exampleEntry.txt
 * 	exampleTxt.txt
 * SuffixFileFilter:
 * 	exampleEntry.txt
 * 	exampleTxt.txt
 * AndFileFilter:
 * 	exampleTxt.txt
 * OrFileFilter:
 * 	exampleEntry.txt
 * 	exampleTxt.txt
 * EmptyFileFilter:
 * 	example
 * 	exampleEntry.txt
 * 	exampleTxt.txt
 * DirectoryFileFilter:
 * 	example
 */