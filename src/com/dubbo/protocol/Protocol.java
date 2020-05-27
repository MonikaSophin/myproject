package com.dubbo.protocol;

import com.dubbo.common.ProtocolModel;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public interface Protocol {

    void start(ProtocolModel protocolModel);

    Object send(ProtocolModel protocolModel);
}
