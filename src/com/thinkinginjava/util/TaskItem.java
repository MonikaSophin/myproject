package com.thinkinginjava.util;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 一个Future和产生它的Callable
 */
public class TaskItem<R,C extends Callable<R>> {
  public final Future<R> future;
  public final C task;
  public TaskItem(Future<R> future, C task) {
    this.future = future;
    this.task = task;
  }
} ///:~
