package com.monika.memcache;

import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 *  Memcached中的append操作
 */
public class TestAppend {

    public static void main(String[] args) {

        try {
            //1. 连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2. set value并检查状态
            Future future = mcc.set("myKey4", 90, "myValue4");
            System.out.println("set status: " + future.get());

            /**
             *  append 命令用于向已存在 key(键) 的 value(数据值) 后面追加数据 。
             *  如果 key 不存在，则追加失败，并且您将获得响应 NOT_STORED。
             */
            //3. key存在
            future = mcc.append("myKey4", "_appendValue4");
            System.out.println("append exist key -- status: " + future.get());
            System.out.println("get(\"myKey4\") : " + mcc.get("myKey4"));

            //4. append 不存在的key
            future = mcc.append("noExistKey", "appendValue");
            System.out.println("append no exist key -- status: " + future.get());

            //5. 断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * set status: true
 * append exist key -- status: true
 * get("myKey4") : myValue4_appendValue4
 * append no exist key -- status: false
 * 断开Memcached服务成功!
 */