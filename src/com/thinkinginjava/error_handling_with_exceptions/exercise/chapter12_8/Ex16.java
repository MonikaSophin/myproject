package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8;

import com.thinkinginjava.reusing_classes.example.chapter7_4.ex7_4_1.CADSystem;

/**
 * @Author: monika
 * @Date: 2018/12/28 23:17
 * @Version: 1.0
 * @Description: page 268
 * 练习16：修改热reusing/CADSystem.java，以演示从try-finally的中间返回仍旧会执行正确的清理。
 */
public class Ex16 {
    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            return;
        } finally {
            x.dispose();
        }
    }
}
/**output:
 * Shape constructor
 * Shape constructor
 * Drawing Line: 0, 0
 * Shape constructor
 * Drawing Line: 1, 1
 * Shape constructor
 * Drawing Line: 2, 4
 * Shape constructor
 * Drawing Circle
 * Shape constructor
 * Drawing Triangle
 * Combined constructor
 * CADSystem.dispose()
 * Erasing Triangle
 * Shape dispose
 * Erasing Circle
 * Shape dispose
 * Erasing Line: 2, 4
 * Shape dispose
 * Erasing Line: 1, 1
 * Shape dispose
 * Erasing Line: 0, 0
 * Shape dispose
 * Shape dispose
 */