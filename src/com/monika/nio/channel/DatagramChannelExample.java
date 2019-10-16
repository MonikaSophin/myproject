package com.monika.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author XueYing.Cao
 * @date 2019/10/15
 */
public class DatagramChannelExample {

    public static void main(String[] args) throws IOException {
        // 1. 打开DatagramChannel
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9999));

        // 2. 从DatagramChannel接收数据包到ByteBuffer中
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        datagramChannel.receive(buffer);

        // 3. 发送数据包到DatagramChannel
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.clear();
        byteBuffer.put("write to ByteBuffer".getBytes());
        byteBuffer.flip();
        datagramChannel.send(byteBuffer, new InetSocketAddress("http://www.baidu.com", 80));

        // 4. 关闭DatagramChannel
        datagramChannel.close();

        /**
         * 可以将DatagramChannel“连接”到网络中的特定地址的。
         * 由于UDP是无连接的，连接到特定地址并不会像TCP通道那样创建一个真正的连接。
         * 而是锁住DatagramChannel ，让其只能从特定地址收发数据。
         */
        DatagramChannel channel = DatagramChannel.open();
        channel.connect(new InetSocketAddress("http://www.baidu.com", 80));
        //当连接后，也可以使用read()和write()方法，就像在用传统的通道一样。只是在数据传送方面没有任何保证。这里有几个例子：
        ByteBuffer buf = ByteBuffer.allocate(48);
        //省略一些步骤...
        int bytesRead = channel.read(buf);
        int bytesWritten = channel.write(buf);

    }
}
