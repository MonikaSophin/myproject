package com.dubbo.protocol.http;

import com.dubbo.common.ProtocolModel;
import com.dubbo.protocol.Protocol;

public class HttpProtocol implements Protocol {

    @Override
    public void start(ProtocolModel protocolModel) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(protocolModel.getIp(), Integer.valueOf(protocolModel.getPort()));
    }

    @Override
    public String send(ProtocolModel protocolModel) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(protocolModel);
    }
}
