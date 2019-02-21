package com.thinkinginjava.util;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * 从中运行Swing演示的工具
 *  console，applet和JFrames
 */
public class SwingConsole {
  public static void
  run(final JFrame f, final int width, final int height) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        f.setTitle(f.getClass().getSimpleName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setVisible(true);
      }
    });
  }
} ///:~
