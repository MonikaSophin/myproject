package com.monika.memcache;

import net.spy.memcached.MemcachedClient;
import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.*;

/**
 * @author XueYing.Cao
 * @date 2019/7/11
 * 在memcached中的set操作
 */
public class TestSet {

    public static void main(String[] args) {
        //1.连接Mecached服务
        MemcachedClient mcc = getMemcachedClient();

        try {

            //2.使用set操作存储数据 key:键 exp:在缓存中保存键值对的时间长度（以秒为单位，0 表示永远） o:值
            Future future = mcc.set("myKey1", 900, "myValue1");

            //3.查看存储状态
            System.out.println("存储状态: " +  future.get());
            //OperationStatus status = ((OperationFuture) future).getStatus();

            //4.获取值
            System.out.println("myKey1在缓存中的值: " + mcc.get("myKey1"));

            //5.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
