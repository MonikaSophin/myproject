package com.thinkinginjava.io.exercise.chapter18_1;

import com.thinkinginjava.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/3/10 22:13
 * @Version: 1.0
 * @Description: page 532
 * 练习05：修改{@link com.thinkinginjava.util.ProcessFiles}，使其匹配正则表达式而不是固定地扩展名。
 */
class ProcessFiles5 {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String regex;
    public ProcessFiles5(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }
    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        Pattern pattern = Pattern.compile(regex);
                        if (pattern.matcher(arg).matches())
                            strategy.process(
                                    new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(
                root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }
}

public class Ex05 {
    // 演示如何使用它:
    public static void main(String[] args) {
        new ProcessFiles5(new ProcessFiles5.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*D.*").start(args);
    }
}
/**output：
 * 略~
 */