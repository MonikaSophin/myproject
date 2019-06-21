package com.design_mode.creational_patterns.prototype_pattern;

import java.util.Hashtable;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedMap = shapeMap.get(shapeId);
        return (Shape) cachedMap.clone();
    }

   // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加如下形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);
    }
}
