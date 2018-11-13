package com.thinkinginjava.access_control.exercise.chapter6_4;

/**
 * @Author: monika
 * @Date: 2018/11/13 22:23
 * @Version: 1.0
 * @Description: page 123
 * 练习09: 在access/local目录下编写以下文件（假定access/local目录在你的CLASSPATH下）：
 * // access/local/PackagedClass.java
 *  class PackagedClass {
 *      public PackagedClass() {
 *          System.out.println("Creating a packaged class");
 *      }
 *  }
 *
 *  然后在access/local之外的另一个目录下中创建下列文件：
 *  // access/foreign/Foreign.java
 *  public class Foreign {
 *      public static void main(String[] args) {
 *         //! PackagedClass pc = new PackagedClass();
 *      }
 *  }
 *
 *  解释以下为什么编译器会产生错误。如果将Foreign类置于access.local包之中的话，会有所改变吗？
 */
public class Ex09 {}

/**解释：
 * 编译器错误是因为PackagedClass类在不是public，所以外部没有权限访问
 * 包权限的类。将Foreign类迁移到local包下，将允许Foreign类访问PackagedClass类。
 */
