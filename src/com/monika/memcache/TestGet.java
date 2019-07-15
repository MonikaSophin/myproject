package com.monika.memcache;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 * Memcached中的get操作
 */
public class TestGet {

    public static void main(String[] args) {

        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2.使用set操作存储数据 key:键 exp:在缓存中保存键值对的时间长度（以秒为单位，0 表示永远） o:值
            Future future = mcc.set("myKey7", 90, "myValue7");

            //3.查看存储状态
            System.out.println("set status: " +  future.get());
            OperationFuture of = (OperationFuture) future;
            System.out.println("set status: " + of.getStatus());

            //4.  get 命令获取存储在 key(键) 中的 value(数据值) ，如果 key 不存在，则返回空。
            System.out.println("get(\"myKey7\") : " + mcc.get("myKey7"));
            System.out.println("get(\"noExistKey\") : " + mcc.get("noExistKey"));

            //5.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * set status: true
 * set status: {OperationStatus success=true:  STORED}
 * get("myKey7") : myValue7
 * get("noExistKey") : null
 * 断开Memcached服务成功!
 */