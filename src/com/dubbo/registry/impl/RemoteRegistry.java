package com.dubbo.registry.impl;

import com.dubbo.common.ProtocolModel;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class RemoteRegistry {

    //    private static final Map<String, List<String>> REGISTRY_MAP = new HashMap<>();
    private static Map<String, List<ProtocolModel>> REGISTRY_MAP = new HashMap<>();

    public static void put(ProtocolModel protocolModel) {

        String url = MessageFormat.format("{0}://{1}:{2}/{3}", protocolModel.getProtocol(),
                protocolModel.getIp(), protocolModel.getPort(), protocolModel.getServiceName());
        if (ArrayUtils.isNotEmpty(protocolModel.getMethodNames())) {
//            url += "&" + ArrayUtils.toString(protocolModel.getMethodNames());
        }

//        List<String> urls = REGISTRY_MAP.get(registryModel.getServiceName());
//        if (CollectionUtils.isEmpty(urls)) {
//            urls.add(url);
//        }

        List<ProtocolModel> protocolModels = REGISTRY_MAP.get(protocolModel.getServiceName());
        if (!CollectionUtils.isEmpty(protocolModels)) {
            protocolModels.add(protocolModel);
        } else {
            protocolModels = new ArrayList<>();
            protocolModels.add(protocolModel);
        }
        REGISTRY_MAP.put(protocolModel.getServiceName(), protocolModels);

        saveFile();
        System.out.println("registry success! > " + url);
    }

    public static List<ProtocolModel> get(String interfaceName) {
        REGISTRY_MAP = getFile();
        return REGISTRY_MAP.get(interfaceName);
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTRY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<ProtocolModel>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<ProtocolModel>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
