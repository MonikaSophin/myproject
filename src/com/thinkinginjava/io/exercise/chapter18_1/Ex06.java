package com.thinkinginjava.io.exercise.chapter18_1;

import com.thinkinginjava.util.ProcessFiles;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: monika
 * @Date: 2019/3/10 22:23
 * @Version: 1.0
 * @Description: page 533
 * 练习06：使用{@link com.thinkinginjava.util.ProcessFiles}来查找
 * 在某个特定目录子树下的所有在某个特定日期之后进行过修改嘚java源代码文件。
 */
public class Ex06 {
    public static void main(final String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: directory date(mm/dd/yyyy)");
            System.out.println("(Outputs a listing of all java files in the given directory" +
                    "\nthat were last modified on or after the given date.)");
            return;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                Date modDate = new Date(file.lastModified());
                try {
                    if(modDate.after(sdf.parse(args[1])))
                        System.out.println(file);
                } catch(ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "java").start(args);
    }
}
/**output:
 * 略~
 */