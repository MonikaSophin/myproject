package com.dubbo.common.reference;

import com.dubbo.common.model.URL;
import com.dubbo.common.registry.RegistryConfig;
import lombok.Data;

/**
 * @author XueYing.Cao
 * @date 2020/5/28
 */
@Data
public class ReferenceConfig<T> {

    private URL url;
    private Class<T> interfaceClass;


    //预留
    private RegistryConfig registryConfig;
    private String group;
    private String version;
}
