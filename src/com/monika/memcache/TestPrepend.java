package com.monika.memcache;

import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 *  Memcached中的prepend操作
 */
public class TestPrepend {

    public static void main(String[] args) {

        try {
            //1. 连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2. set value并检查状态
            Future future = mcc.set("myKey5", 90, "myValue5");
            System.out.println("set status: " + future.get());

            /**
             *   prepend 命令用于向已存在 key(键) 的 value(数据值) 前面追加数据 。
             *   如果 key 不存在，则追加失败，并且您将获得响应 NOT_STORED。
             */
            //3. key存在
            future = mcc.prepend("myKey5", "prependValue5_");
            System.out.println("prepend exist key -- status: " + future.get());
            System.out.println("get(\"myKey5\") : " + mcc.get("myKey5"));

            //4. append 不存在的key
            future = mcc.prepend("noExistKey", "prependValue");
            System.out.println("prepend no exist key -- status: " + future.get());

            //5. 断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * set status: true
 * prepend exist key -- status: true
 * get("myKey5") : prependValue5_myValue5
 * prepend no exist key -- status: false
 * 断开Memcached服务成功!
 */