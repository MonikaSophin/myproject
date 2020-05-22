package com.monika.proxy.dynamic.self;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/22 0:03
 * @Version 1.0
 * @Description 模拟jdk动态代理的工具类
 */
public class ProxyUtils {

    /**
     * 这里模拟动态代理的过程是：生成$Proxy.java---->$Proxy.class--[ClassLoader]--> 字节码
     * JDK动态代理的过程是：直接生成字节码
     */
    public Object newIntance(Object target, Handler handler) throws Exception {

        Class[] clazz = target.getClass().getInterfaces();
        String n = "\n";
        String t = "\t";
        //package 包名
        String packageName = ProxyUtils.class.getPackage().getName();

        // import 全限定类名
        List<String> classNameList = Arrays.stream(clazz).map(Class::getName).collect(Collectors.toList());
        StringBuilder classNames = new StringBuilder();
        classNameList.forEach(interfacePackageName -> classNames.append("import ").append(interfacePackageName).append(";").append(n));

        //接口名
        List<String> simpleClassNameList = Arrays.stream(clazz).map(Class::getSimpleName).collect(Collectors.toList());
        String names1 = StringUtils.join(simpleClassNameList.toArray(), ", ");

        String[] nameFileds = simpleClassNameList.stream()
                .map(interfaceName -> interfaceName.substring(0, 1).toLowerCase() + interfaceName.substring(1))
                .toArray(String[]::new);

        //变量名 private Xyz xyz;
        StringBuilder names2 = new StringBuilder();
        IntStream.range(0, simpleClassNameList.size()).forEach(i ->
                names2.append(t).append("private ").append(simpleClassNameList.get(i)).append(" ").append(nameFileds[i]).append(";").append(n));

        // 构造参数名 Xyz xyz
        StringBuilder names3 = new StringBuilder();
        IntStream.range(0, simpleClassNameList.size()).forEach(i -> {
            if (i < simpleClassNameList.size() - 1) {
                names3.append(simpleClassNameList.get(i)).append(" ").append(nameFileds[i]).append(", ");
            } else {
                names3.append(simpleClassNameList.get(i)).append(" ").append(nameFileds[i]);
            }
        });

        // 构造方法体
        StringBuilder method1 = new StringBuilder();
        IntStream.range(0, simpleClassNameList.size()).forEach(i ->
                method1.append(t).append(t).append("this.").append(nameFileds[i]).append(" = ").append(nameFileds[i]).append(";").append(n));

        // 代理方法体
        StringBuilder method2 = new StringBuilder();
        IntStream.range(0, clazz.length).forEach(i -> {
            Method[] declaredMethods = clazz[i].getDeclaredMethods();
            Arrays.stream(declaredMethods).forEach(method -> {
                method.setAccessible(true);
                String returnType = method.getReturnType().getSimpleName();
                String methodName = method.getName();
                method2.append(t).append("public ").append(returnType).append(" ").append(methodName).append("()").append(" ").append("{").append(n)
                        .append(t).append(t).append("System.out.println(\"").append(handler.invoke()).append("\");").append(n) //简单模拟handler执行invoke
                        .append(t).append(t).append(nameFileds[i]).append(".").append(methodName).append("();").append(n)
                        .append(t).append("}").append(n);
            });
        });

        StringBuilder javaFile = new StringBuilder();
        javaFile.append("package ").append(packageName).append(";").append(n).append(n)
                .append(classNames).append(n)
                .append("public class $Proxy implements ").append(names1).append(" {").append(n).append(n)
                .append(names2).append(n)
                .append(t).append("public $Proxy(").append(names3).append(") ").append("{").append(n)
                .append(method1)
                .append(t).append("}").append(n).append(n)
                .append(method2)
                .append("}");
//        System.out.println(javaFile);

        InputStream is = new ByteArrayInputStream(javaFile.toString().getBytes());
        String resoureDir = "D:\\com\\monika\\proxy\\dynamic\\self\\$Proxy.java";
        FileUtils.copyInputStreamToFile(is, new File(resoureDir));

        boolean b = JavaCompilerUtils.CompilerJavaFile(resoureDir, "D:\\");
        if (b) {
            URL url = new URL("file:\\D:\\");
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
            Class<?> aClass = classLoader.loadClass(packageName + ".$Proxy");
//            System.out.println(aClass);
            Constructor<?> constructor = aClass.getConstructor(clazz);
            Object o1 = constructor.newInstance(target);
            return o1;
        }
        return null;
    }
}
