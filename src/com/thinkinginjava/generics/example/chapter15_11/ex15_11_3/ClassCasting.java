package com.thinkinginjava.generics.example.chapter15_11.ex15_11_3;

import com.thinkinginjava.access_control.exercise.chapter6_4.access.Widget;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/16 19:33
 * @Version: 1.0
 * @Description:
 */
public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0]));
        // 不能编译
       // List<Widget> lw1 = List<Widget>.class.cast(in.readObject());
        List<Widget> lw2 = List.class.cast(in.readObject());
    }
}
