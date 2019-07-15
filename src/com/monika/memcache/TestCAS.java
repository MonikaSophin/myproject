package com.monika.memcache;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 * Memcached中的CAS操作
 *   检查是通过cas_token参数进行的， 这个参数是Memcach指定给已经存在的元素的一个唯一的64位值。
 * 该值是作递增操作的。
 */
public class TestCAS {

    public static void main(String[] args) {
        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2.set value并检查状态
            Future future = mcc.set("myKey6", 90, "myValue6");
            System.out.println("set status: " + future.get());

            //3.使用gets获取cas令牌
            CASValue<Object> casValue = mcc.gets("myKey6");
            System.out.println("cas value: " + casValue);

            //4. key存在，cas操作
            CASResponse casResponse = mcc.cas("myKey6", casValue.getCas(), 90, "casValue6");
            System.out.println("cas exist key -- status: " + casResponse);
            System.out.println("get(\"myKey6\") : " + mcc.get("myKey6"));

            //5. key不存在，cas操作
            casResponse = mcc.cas("noExistKey", casValue.getCas(), 90, "appendValue");
            System.out.println("cas no exist key -- status: " + casResponse);

            //6. 断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
/**output(Sample):
 * set status: true
 * cas value: {CasValue 40/myValue6}
 * cas exist key -- status: OK
 * get("myKey6") : casValue6
 * cas no exist key -- status: NOT_FOUND
 * 断开Memcached服务成功!
 */