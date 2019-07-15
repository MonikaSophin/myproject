package com.monika.memcache;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 * Memcached中的incr/decr操作
 */
public class TestIncrDecr {

    public static void main(String[] args) {

        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2.使用set操作存储数据 key:键 exp:在缓存中保存键值对的时间长度（以秒为单位，0 表示永远） o:值
            Future future = mcc.set("myKey10", 900, 20);

            //3.查看存储状态
            System.out.println("set status: " +  future.get());

            //4. incr 与 decr 命令用于对已存在的 key(键) 的数字值进行自增或自减操作。
            long result1 = mcc.incr("myKey10", 12);
            System.out.println("incr(\"myKey10\", 11) : " + result1);
            System.out.println("get(\"myKey10\") : " + mcc.get("myKey10"));

            long result2 = mcc.incr("noExistKey", 10);
            System.out.println("incr(\"noExistKey\", 10) : " + result2);

            //5.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}