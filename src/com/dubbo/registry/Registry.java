package com.dubbo.registry;

import com.dubbo.common.ProtocolModel;

import java.util.List;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public interface Registry {

    void put(ProtocolModel registryModel);
    List<ProtocolModel> get(String interfaceName);
}
