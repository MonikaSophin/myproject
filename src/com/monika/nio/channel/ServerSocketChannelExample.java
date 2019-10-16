package com.monika.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author XueYing.Cao
 * @date 2019/10/15
 */
public class ServerSocketChannelExample {

    public static void main(String[] args) throws IOException {
        /**
         * 非阻塞方式
         * ServerSocketChannel可以设置成非阻塞模式。
         * 在非阻塞模式下，accept()方法会立刻返回，如果还没有新进来的连接,返回的将是null。
         * 因此，需要检查返回的SocketChannel是否是null.如：
         */
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        channel.configureBlocking(false);// 设置为非阻塞方式
//        while (true) {
//            SocketChannel socket = channel.accept();
//            if (socket != null) {
//                //省略一些读写操作等
//            }
//        }


        //1. 打开ServerSocketChannel并监听进入的新连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        while (true) {
            //通过ServerSocketChannel.accept()方法监听新进来的连接。
            // 当accept()方法返回的时候，它返回一个包含新进来的连接的SocketChannel。
            // 因此，accept()方法会一直都有到新连接。
            SocketChannel socketChannel = serverSocketChannel.accept();

            // 2. 从ServerSocketChannel中读取数据到ByteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            byteBuffer.clear();
            int read = socketChannel.read(byteBuffer);

            // 3. 向ServerSocketChannel中写入数据
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            buffer.put("write to ByteBuffer".getBytes());
            buffer.flip();
            socketChannel.write(buffer);

            // 4. 关闭serverSocketChannel
            serverSocketChannel.close();
        }


    }
}
