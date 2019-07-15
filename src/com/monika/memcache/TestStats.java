package com.monika.memcache;

import net.spy.memcached.MemcachedClient;

import java.net.SocketAddress;
import java.util.Map;

import static com.monika.memcache.MemcacheClientManager.getMemcachedClient;
import static com.monika.memcache.MemcacheClientManager.shutdownMemcachedClient;

/**
 * @author XueYing.Cao
 * @date 2019/7/12
 *
 * stats 命令用于返回统计信息例如 PID(进程号)、版本号、连接数等。
 * stats items 命令用于显示各个 slab 中 item 的数目和存储时长(最后一次访问距离现在的秒数)。
 * stats slabs 命令用于显示各个slab的信息，包括chunk的大小、数目、使用情况等。
 * stats sizes 命令用于显示所有item的大小和个数。
 * flush_all 命令用于清理缓存中的所有 key=>value(键=>值) 对。
 */
public class TestStats {

    public static void main(String[] args) {
        try {
            //1.连接Mecached服务
            MemcachedClient mcc = getMemcachedClient();

            //2. 使用stats命令 获取统计信息
            Map<SocketAddress, Map<String, String>> stats = mcc.getStats();
            System.out.println(stats);

            //3.断开连接
            shutdownMemcachedClient();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**output(Sample):
 * {/127.0.0.1:11211={incr_hits=7, get_hits=44, delete_hits=7, evictions=0, pid=5128, cas_badval=0, curr_connections=14, cmd_flush=0, total_items=83, bytes_written=5683, cas_hits=2, accepting_conns=1, auth_errors=0, decr_hits=0, limit_maxbytes=67108864, decr_misses=12, reclaimed=15, cmd_get=52, curr_items=1, threads=4, cmd_set=106, bytes_read=4975, conn_yields=0, version=1.4.5_4_gaa7839e, uptime=20400, listen_disabled_num=0, total_connections=80, get_misses=8, incr_misses=13, connection_structures=17, bytes=75, time=1562919231, auth_cmds=0, pointer_size=64, cas_misses=2, delete_misses=6}}
 * 断开Memcached服务成功!
 */