package com.monika.proxy.dynamic;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/22 0:03
 * @Version 1.0
 * @Description
 * 模拟jdk动态代理的工具类
 */
public class ProxyUtils {

    /**
     * 这里模拟动态代理的过程是：生成$Proxy.java---->$Proxy.class--[ClassLoader]--> 字节码
     * JDK动态代理的过程是：直接生成字节码
     */
    public Object newIntance(Class[] clazz, InvocationHandler handler) {
        String n = "\n";
        String t = "\t";
        //包名
        List<String> interfacePackageNames = Arrays.stream(clazz).map(Class::getName).collect(Collectors.toList());
        StringBuilder packageNames = new StringBuilder();
        interfacePackageNames.forEach(interfacePackageName -> packageNames.append("package ").append(interfacePackageName).append(";").append(n));
        //接口名
        List<String> interfaceNames = Arrays.stream(clazz).map(Class::getName).collect(Collectors.toList());
        String names1 = StringUtils.join(interfaceNames.toArray(), ", ");
        //变量名
        String[] nameFileds = interfaceNames.stream()
                .map(interfaceName -> interfaceName.substring(0,1).toLowerCase() + interfaceName.substring(1))
                .toArray(String[]::new);

        StringBuilder names2 = new StringBuilder();
        IntStream.range(0, interfaceNames.size()).forEach(i ->
                names2.append(t).append("private ").append(interfaceNames.get(i)).append(" ").append(nameFileds[i]).append(";").append(n));

        // 构造参数名 private Xyz xyz;
        StringBuilder names3 = new StringBuilder();
        IntStream.range(0, interfaceNames.size()).forEach(i -> {
            if (i < interfaceNames.size() - 1) {
                names3.append(interfaceNames.get(i)).append(" ").append(nameFileds[i]).append(", ");
            }
            names3.append(interfaceNames.get(i)).append(" ").append(nameFileds[i]);
        });

        // 构造方法体
        StringBuilder names4 = new StringBuilder();
        IntStream.range(0, interfaceNames.size()).forEach(i ->
            names4.append(t).append(t).append("this.").append(nameFileds[i]).append(" = ").append(nameFileds[i]).append(";").append(n));

        MessageFormat.format(
                "package com.monika.proxy.dynamic;" + n + n
                + "{0}" + n
                + "public class $Proxy implements {1} {" + n + n
                + "{2}" + n
                + t + "public $Proxy({3}) {" + n
                + "{4}"
                + t + "}" + n + n
                +
                "    @Override\n" +
                "    public void doSomething() {\n" +
                "        System.out.println(\"execute proxy service，eg：骑手送外卖\");\n" +
                "        service.doSomething();\n" +
                "    }\n" +
                "}\n", packageNames.toString(), names1, names2.toString(), names3.toString(), names4.toString());
        return null;
    }
}
