package com.thinkinginjava.interfaces.example.chapter9_7;

/**
 * 1.在接口中定义的域都自动是static和final的，所以在JavaSE5之前接口就成为了
 * 一种很便捷的用来创建常量组的工具。（Java SE5之后被enum替代）
 */
public interface Months {
  int
    JANUARY = 1, FEBRUARY = 2, MARCH = 3,
    APRIL = 4, MAY = 5, JUNE = 6, JULY = 7,
    AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
    NOVEMBER = 11, DECEMBER = 12;
} ///:~
