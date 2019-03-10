package com.thinkinginjava.io.exercise.chapter18_1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/3/10 20:39
 * @Version: 1.0
 * @Description: page 528
 * 练习03：修改DirList.java（或其变体之一），使其对所选中的文件计算文件尺寸的总和。
 */
public class Ex03 {
    public static void main(final String[] args) {
        File path = new File(".");
        File[] files;
        if(args.length == 0)
            files = path.listFiles();
        else
            files = path.listFiles(new FileFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File file) {
                    return pattern.matcher(file.getPath()).matches();
                }
            });
        Arrays.sort(files);
        long sum = 0;
        for(File f : files) {
            System.out.print(f + ": ");
            System.out.println(f.length());
            sum += f.length();
        }
        System.out.println("Total size: " + sum);
    }
}
