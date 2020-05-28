package com.dubbo.protocol.http;

import com.dubbo.common.model.Invocation;
import com.dubbo.common.model.URL;
import com.dubbo.protocol.Protocol;

public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHost(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url, invocation);
    }
}
