package com.dubbo.common.service;

import com.dubbo.common.model.URL;
import com.dubbo.common.registry.RegistryConfig;
import lombok.Data;

import java.util.List;

/**
 * @author XueYing.Cao
 * @date 2020/5/28
 */
@Data
public class ServiceConfig<T> {

    private List<URL> urls;
    private Class<T> interfaceClass;
    private T refObject;

    //预留
    private RegistryConfig registryConfig;
    private String group;
    private String version;
}
