package com.monika.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author XueYing.Cao
 * @date 2019/10/14
 */
public class SocketChannelExample {

    public static void main(String[] args) {
        try {
            // 1. 打开SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));

            // 2. 从SocketChannel中读取数据
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            int read = socketChannel.read(buffer);

            // 3. 向SocketChannel中写入数据
            ByteBuffer buffer1 = ByteBuffer.allocate(48);

            buffer1.clear(); // clear()使ByteBuffer准备进入write模式
            buffer1.put("clear() start ByteBuffer-write".getBytes());

            buffer1.flip(); // flip()使ByteBuffer准备进入read模式
            while (buffer1.hasRemaining()) {
                socketChannel.write(buffer);
            }

            // 4. 关闭SocketChannel
            socketChannel.close();

            /**
             * 非阻塞模式
             * 可以设置 SocketChannel 为非阻塞模式（non-blocking mode）.
             * 设置之后，就可以在异步模式下调用connect(), read() 和write()了。
             */
            SocketChannel channel = SocketChannel.open();
            // 设置为非阻塞方式
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("http://www.baidu.com", 80));

            /**
             * 如果SocketChannel在非阻塞模式下，此时调用connect()，该方法可能在连接建立之前就返回了。
             * 为了确定连接是否建立，可以调用finishConnect()的方法。像这样：
             */
            if (!channel.finishConnect()) {
                // 等待连接进入，或者其他操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
