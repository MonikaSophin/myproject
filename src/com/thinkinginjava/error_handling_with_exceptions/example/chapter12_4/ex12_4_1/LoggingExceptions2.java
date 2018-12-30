package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1;

import java.util.logging.*;
import java.io.*;

public class LoggingExceptions2 {
  private static Logger logger = Logger.getLogger("LoggingExceptions2");
  static void logException(Exception e) {
    StringWriter trace = new StringWriter();
    e.printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }

  public static void main(String[] args) {
    try {
      throw new NullPointerException();
    } catch(NullPointerException e) {
      logException(e);
    }
  }
}
/** Output (90% match):
 * 十二月 26, 2018 11:03:14 下午 com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingExceptions2 logException
 * 严重: java.lang.NullPointerException
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingExceptions2.main(LoggingExceptions2.java:17)
 */
