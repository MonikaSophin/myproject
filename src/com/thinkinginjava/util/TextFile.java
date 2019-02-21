package com.thinkinginjava.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 用于读取和写入文本文件的静态函数一个字符串，并将文件视为ArrayList
 */
public class TextFile extends ArrayList<String> {
  // 将文件作为单个字符串读取:
  public static String read(String fileName) {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader in= new BufferedReader(new FileReader(
        new File(fileName).getAbsoluteFile()));
      try {
        String s;
        while((s = in.readLine()) != null) {
          sb.append(s);
          sb.append("\n");
        }
      } finally {
        in.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }

  //在一个方法调用中写入单个文件:
  public static void write(String fileName, String text) {
    try {
      PrintWriter out = new PrintWriter(
        new File(fileName).getAbsoluteFile());
      try {
        out.print(text);
      } finally {
        out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 读取文件，按任何正则表达式拆分:
  public TextFile(String fileName, String splitter) {
    super(Arrays.asList(read(fileName).split(splitter)));
    // 正则表达式split（）经常在第一个位置留下一个空String:
    if(get(0).equals("")) remove(0);
  }

  // 通常按行阅读:
  public TextFile(String fileName) {
    this(fileName, "\n");
  }

  public void write(String fileName) {
    try {
      PrintWriter out = new PrintWriter(
        new File(fileName).getAbsoluteFile());
      try {
        for(String item : this)
          out.println(item);
      } finally {
        out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 简单的测试:
  public static void main(String[] args) {
    String file = read("src\\com\\thinkinginjava\\util\\TextFile.java");
    write("test.txt", file);
    TextFile text = new TextFile("test.txt");
    text.write("test2.txt");
    // 分成独特的排序单词列表:
    TreeSet<String> words = new TreeSet<>(
      new TextFile("src\\com\\thinkinginjava\\util\\TextFile.java", "\\W+"));
    // 显示大写单词:
    System.out.println(words.headSet("a"));
  }
}
/**Output:
 * [0, ArrayList, Arrays, Break, BufferedReader, BufferedWriter, Clean, Display, File, FileReader, FileWriter, IOException, Normally, Output, PrintWriter, Read, Regular, RuntimeException, Simple, Static, String, StringBuilder, System, TextFile, Tools, TreeSet, W, Write]
 */