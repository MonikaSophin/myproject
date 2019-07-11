package com.monika.memcache;

import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author XueYing.Cao
 * @date 2019/7/11
 */
public class MemcacheClientManager {
    private static MemcachedClient memcachedClient;

    static {
        try {
            // 本地连接 Memcached 服务
            memcachedClient = new MemcachedClient(
                    new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("连接Memcached服务成功!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }

    public static void shutdownMemcachedClient() {
        // 关闭连接
        if (memcachedClient == null) {
            throw new RuntimeException("Memcache客户端不存在!");
        }
        memcachedClient.shutdown();
        System.out.println("断开Memcached服务成功!");
    }
}
