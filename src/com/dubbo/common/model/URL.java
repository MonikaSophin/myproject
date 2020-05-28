package com.dubbo.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author XueYing.Cao
 * @date 2020/5/28
 *
 * URL 格式：protocol://username:password@host:port/path?key=value&key=value
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URL implements Serializable {

    public URL(String protocol, String path) {
        this.protocol = protocol;
        this.path = path;
    }

    /**
     * 协议名
     */
    private String protocol;

    /**
     * 用户名
     */
//    private final String username;

    /**
     * 密码
     */
//    private final String password;

    /**
     * by default, host to registry
     * 地址
     */
    private String host;

    /**
     *  // by default, port to registry
     *  端口
     */
    private int port;

    /**
     * 路径（服务名）
     */
    private String path;

    @Override
    public String toString() {
        return buildUrl(this);
    }

    public static String buildUrl(URL url) {
        return MessageFormat.format("{0}://{1}:{2}/{3}", url.getProtocol(),
               url.getHost(), Integer.toString(url.getPort()), url.getPath());
    }
}
