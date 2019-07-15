package com.monika.memcache;

import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.*;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 * Memcached中的add操作
 */
public class TestAdd {

    public static void main(String[] args) {
        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2.set value并检查状态
            Future future = mcc.set("myKey2", 90, "myValue2");
            System.out.println("set status: " + future.get());

            //3. 如果 add 的 key 已经存在，则不会更新数据(过期的 key 会更新)，之前的值将仍然保持相同，并且您将获得响应 NOT_STORED。
            future = mcc.add("myKey2", 90, "addValue");
            System.out.println("add value in old key -- status: " + future.get());

            //4.向新的key添加value
            future = mcc.add("newKey1", 90, "newValue1");
            System.out.println("add value in new key -- status: " + future.get());
            System.out.println("get(\"newKey1\") : " + mcc.get("newKey1"));

            //5.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
/**output:
 * set status: true
 * add value in old key -- status: false
 * add value in new key -- status: true
 * get("newKey1") : newValue1
 * 断开Memcached服务成功!
 */