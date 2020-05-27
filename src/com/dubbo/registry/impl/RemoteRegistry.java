package com.dubbo.registry.impl;

import com.dubbo.protocol.Protocol;
import com.dubbo.registry.Registry;
import com.dubbo.common.ProtocolModel;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class RemoteRegistry implements Registry {

    //    private static final Map<String, List<String>> REGISTRY_MAP = new HashMap<>();
    private static final Map<String, List<ProtocolModel>> REGISTRY_MAP = new HashMap<>();

    @Override
    public void put(ProtocolModel registryModel) {

        String url = MessageFormat.format("%s://%s:%s/%s", registryModel.getProtocol(),
                registryModel.getIp(), registryModel.getPort(), registryModel.getServiceName());
        if (ArrayUtils.isNotEmpty(registryModel.getMethodNames())) {
            url += "&" + ArrayUtils.toString(registryModel.getMethodNames());
        }

//        List<String> urls = REGISTRY_MAP.get(registryModel.getServiceName());
//        if (CollectionUtils.isEmpty(urls)) {
//            urls.add(url);
//        }

        List<ProtocolModel> urls = REGISTRY_MAP.get(registryModel.getServiceName());

        REGISTRY_MAP.put(registryModel.getServiceName(), urls);

        saveFile();
        System.out.println("registry success! > " + url);
    }

    @Override
    public List<ProtocolModel> get(String interfaceName) {
        getFile();
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
