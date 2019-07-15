package com.monika.memcache;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 * Memcached中的delete操作
 */
public class TestDelete {

    public static void main(String[] args) {

        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2.使用set操作存储数据 key:键 exp:在缓存中保存键值对的时间长度（以秒为单位，0 表示永远） o:值
            Future future = mcc.set("myKey9", 90, "myValue9");

            //3.查看存储状态
            System.out.println("set status: " +  future.get());

            //4. delete 命令用于删除已存在的 key(键)。 如果 key 不存在，则返回空。
            OperationFuture<Boolean> future1 = mcc.delete("myKey9");
            System.out.println("delete(\"myKey9\") : " + future1.getStatus());
            OperationFuture<Boolean> future2 = mcc.delete("noExistKey");
            System.out.println("delete(\"noExistKey\") : " + future2.getStatus());

            //5.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * set status: true
 * delete("myKey9") : {OperationStatus success=true:  DELETED}
 * delete("noExistKey") : {OperationStatus success=false:  NOT_FOUND}
 * 断开Memcached服务成功!
 */