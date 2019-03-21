package com.thinkinginjava.io.example.chapter18_12.ex18_12_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/21
 * @description:
 */
public class RecoverCADState {
    static String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_12\\file\\StoreCADState.out";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath));
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();

        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
