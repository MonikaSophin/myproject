package com.thinkinginjava.generics.exercise.chapter15_8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/13
 * @description: page 381
 * 练习21：修改ClassTypeCapture.java,添加一个Map<String,Class<?>>.一个addType(String typename, Class<?> kind)
 * 方法和一个createNew(String typename)方法。createNew()将产生一个与其参数字符串相关联的类的新实例，或者产生一条
 * 错误信息。
 */

class Building {}
class House extends Building {}

class ClassTypeCapture<T> {
    public final Class<T> kind;
    public final Map<String, Class<?>> map = new HashMap<>();
    public ClassTypeCapture(Class<T> kind) { this.kind = kind; }
    public boolean f(Object arg) { return kind.isInstance(arg); }
    public void addType(String typename, Class<?> kind) {
        try {
            Class<?> aClass = Class.forName(typename);
            if (aClass == kind)
                map.put(typename, kind);
            else
                System.out.println(String.format("%s 与 %s类型不匹配", typename, kind));
        } catch (ClassNotFoundException e) {
            System.out.println("类型未被找到!");
        }
    }
    public Object createNew(String typename) {
        try {
            if (map.containsKey(typename)) {
                Class<?> aClass = map.get(typename);
                Object o = aClass.newInstance();
                return o;
            }
        } catch (Exception e) {
            System.out.println("创建新实例错误! typename = " + typename);
        }
        return null;
    }
}

public class Ex21 {
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
        System.out.println();

        ClassTypeCapture<Building> ct = new ClassTypeCapture<>(Building.class);
        ct.addType("com.thinkinginjava.generics.exercise.chapter15_8.Building", House.class);
        ct.addType("com.thinkinginjava.generics.exercise.chapter15_8.Building", Building.class);
        ct.addType("com.thinkinginjava.generics.exercise.chapter15_8.House", House.class);
        System.out.println("map: " + ct.map);
        Building b = (Building)ct.createNew("com.thinkinginjava.generics.exercise.chapter15_8.Building");
        House h = (House)ct.createNew("com.thinkinginjava.generics.exercise.chapter15_8.House");
        System.out.println("h instanceof Building => " + (h instanceof Building));
        System.out.println("b instanceof Building => " + (b instanceof Building));
        System.out.println("h instanceof House => " + (h instanceof House));
        System.out.println("b instanceof House => " + (b instanceof House));
    }
}
/**output:
 * true
 * true
 * false
 * true
 *
 * com.thinkinginjava.generics.exercise.chapter15_8.Building 与 class com.thinkinginjava.generics.exercise.chapter15_8.House类型不匹配
 * map: {com.thinkinginjava.generics.exercise.chapter15_8.Building=class com.thinkinginjava.generics.exercise.chapter15_8.Building, com.thinkinginjava.generics.exercise.chapter15_8.House=class com.thinkinginjava.generics.exercise.chapter15_8.House}
 * h instanceof Building => true
 * b instanceof Building => true
 * h instanceof House => true
 * b instanceof House => false
 */