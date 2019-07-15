package com.monika.memcache;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 * Memcached中的gets操作
 */
public class TestGets {

    public static void main(String[] args) {

        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2.使用set操作存储数据 key:键 exp:在缓存中保存键值对的时间长度（以秒为单位，0 表示永远） o:值
            Future future = mcc.set("myKey8", 90, "myValue8");

            //3.查看存储状态
            System.out.println("set status: " +  future.get());

            //4. gets 命令获取带有 CAS 令牌存 的 value(数据值) ，如果 key 不存在，则返回空。
            CASValue<Object> casValue = mcc.gets("myKey8");
            System.out.println("gets(\"myKey8\") : " + casValue);
            System.out.println("gets cas: " + casValue.getCas());
            System.out.println("gets value: " + casValue.getValue());
            System.out.println("gets(\"noExistKey\") : " + mcc.gets("noExistKey"));

            //5.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * set status: true
 * gets("myKey8") : {CasValue 46/myValue8}
 * gets cas: 46
 * gets value: myValue8
 * gets("noExistKey") : null
 * 断开Memcached服务成功!
 */