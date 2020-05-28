package com.dubbo.registry.impl;

import com.dubbo.common.model.URL;
import com.dubbo.common.service.ServiceConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 * 采用存储文件的形式 模拟 注册中心
 */
public class RemoteRegistry {

    private static Map<String, List<URL>> REGISTRY_MAP = new HashMap<>();
    private static Map<String, Class> IMPL_MAP = new HashMap<>();

    public static <T> void put(ServiceConfig<T> serviceConfig) {

        List<URL> urls = REGISTRY_MAP.get(serviceConfig.getInterfaceClass().getName());
        if (!CollectionUtils.isEmpty(urls)) {
            urls.addAll(serviceConfig.getUrls());
        } else {
            urls = new ArrayList<>(serviceConfig.getUrls());
        }
        REGISTRY_MAP.put(serviceConfig.getInterfaceClass().getName(), urls);
        IMPL_MAP.put(serviceConfig.getInterfaceClass().getName(), serviceConfig.getRefObject().getClass());

        saveFile("/registry.txt", REGISTRY_MAP);
        saveFile("/impl.txt", IMPL_MAP);
        System.out.println("registry success! > " + urls);
    }

    public static List<URL> getURL(String interfaceName, URL consumer) {
        REGISTRY_MAP = getFile1();
        return compare(REGISTRY_MAP.get(interfaceName), consumer);
    }

    public static Class getImpl(String interfaceName) {
        IMPL_MAP = getFile2();
        return IMPL_MAP.get(interfaceName);
    }

    private static List<URL> compare(List<URL> providers, URL consumer) {
        return providers.stream()
                .filter(e -> e.getProtocol().equals(consumer.getProtocol()))
                .filter(e -> e.getPath().equals(consumer.getPath()))
                .filter(e -> {
                    if (consumer.getPort() > 0) {
                        return e.getPort() == consumer.getPort();
                    }
                    return true;
                })
                .filter(e -> {
                    if (StringUtils.isNotEmpty(consumer.getHost())) {
                        return consumer.getHost().equals(e.getHost());
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

    private static void saveFile(String fileName, Object object) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile1() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/registry.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map<String, Class> getFile2() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/impl.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, Class>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
