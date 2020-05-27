package com.dubbo.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.common.ProtocolModel;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {

    public String send(ProtocolModel protocolModel) {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String uri = String.format("http://%s:%s/", protocolModel.getIp(), protocolModel.getPort());
        HttpPost httpPost = new HttpPost(uri);
        // 设置报文和通讯格式
        StringEntity stringEntity;
        try {
            stringEntity = new StringEntity(JSONObject.toJSONString(protocolModel));
            stringEntity.setContentEncoding("utf-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);

            // 响应模型
            CloseableHttpResponse response = null;
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

