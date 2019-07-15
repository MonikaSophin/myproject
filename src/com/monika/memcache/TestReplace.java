package com.monika.memcache;

import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 *  Memcached中的replace操作
 */
public class TestReplace {

    public static void main(String[] args) {

        try {
            //1. 连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2. set value并检查状态
            Future future = mcc.set("myKey3", 90, "myValue3");
            System.out.println("set status: " + future.get());

            /**
             *  replace 命令用于替换已存在的 key(键) 的 value(数据值)。
             * 如果 key 不存在，则替换失败，并且您将获得响应 NOT_STORED。
             */
            //3. key存在
            future = mcc.replace("myKey3", 90, "replaceValue3");
            System.out.println("replace exist key -- status: " + future.get());
            System.out.println("get(\"myKey3\") : " + mcc.get("myKey3"));

            //4. replace 不存在的key
            future = mcc.replace("noExistKey", 90, "replaceValue");
            System.out.println("replace no exist key -- status: " + future.get());

            //5. 断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output:
 * set status: true
 * replace exist key -- status: true
 * get("myKey3") : replaceValue3
 * replace no exist key -- status: false
 * 断开Memcached服务成功!
 */