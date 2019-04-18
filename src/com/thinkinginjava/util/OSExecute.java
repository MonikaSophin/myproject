package com.thinkinginjava.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 运行操作系统命令并将输出发送到控制台。
 */
public class OSExecute {
  public static void command(String command) {
    boolean err = false;
    try {
      Process process = new ProcessBuilder(command.split(" ")).start();
      BufferedReader results = new BufferedReader(
        new InputStreamReader(process.getInputStream()));
      String s;
      while((s = results.readLine())!= null)
        System.out.println(s);
      BufferedReader errors = new BufferedReader(
        new InputStreamReader(process.getErrorStream()));

      // 如果有问题，报告错误并将返回非零值 调用进程:
      while((s = errors.readLine())!= null) {
        System.err.println(s);
        err = true;
      }
    } catch(Exception e) {
      // 补偿Windows 2000，它会为默认命令行抛出异常:
      if(!command.startsWith("CMD /C"))
        command("CMD /C " + command);
      else
        throw new RuntimeException(e);
    }
    if(err)
      throw new OSExecuteException("Errors executing " +
        command);
  }
} ///:~
