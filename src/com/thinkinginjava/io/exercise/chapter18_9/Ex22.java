package com.thinkinginjava.io.exercise.chapter18_9;

import com.thinkinginjava.util.OSExecute;
import com.thinkinginjava.util.OSExecuteException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 551
 * 练习22：修改{@link OSExecute}，使其不打印标准输出流，而是以List或多个String的方法
 * 返回执行程序后的结果。演示对这个实用工具的新版本的实用方式。
 */
class OSExecute22 {
    public static List<String> command(String command) {
        boolean err = false;
        List<String> ls = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(
                    command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine()) != null) {
                ls.add(s);
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            // 如果有问题，报告错误并将非零值返回到调用进程:
            while((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch(Exception e) {
            // 补偿Windows 2000，它为默认命令行抛出异常:
            if(!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if(err)
            throw new OSExecuteException("Errors executing " + command);
        return ls;
    }
}

public class Ex22 {
    public static void main(String[] args) {
        OSExecute22.command("javap Ex22");
    }
}
/**
 * 略~
 */