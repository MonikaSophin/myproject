package com.monika.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author XueYing.Cao
 * @date 2019/10/15
 */
public class SelectorExample {

    public static void main(String[] args) {
        try(
                SocketChannel socketChannel = SocketChannel.open();
                Selector selector = Selector.open()
        ) {
            socketChannel.socket().connect(new InetSocketAddress("http://www.baidu.com", 9999));

            /**
             * 与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，
             * 因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
             */
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT
                    | SelectionKey.OP_WRITE | SelectionKey.OP_READ);
            while (true) {
                /**
                 * 一旦向Selector注册了一或多个通道，就可以调用几个重载的select()方法。
                 * 这些方法返回你所感兴趣的事件（如连接、接受、读或写）已经准备就绪的那些通道。
                 * 换句话说，如果你对“读就绪”的通道感兴趣，select()方法会返回读事件已经就绪的那些通道。
                 */
                int readyChannels = selector.select();

                /**
                 * 某个线程调用select()方法后阻塞了，即使没有通道已经就绪，也有办法让其从select()方法返回。
                 * 只要让其它线程在第一个线程调用select()方法的那个对象上调用Selector.wakeup()方法即可。
                 * 阻塞在select()方法上的线程会立马返回。
                 * 如果有其它线程调用了wakeup()方法，但当前没有线程阻塞在select()方法上，
                 * 下个调用select()方法的线程会立即“醒来（wake up）”。
                 */
                // Selector wakeup = selector.wakeup();
                if (readyChannels == 0) {
                    continue;
                }

                /**
                 * 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，
                 * 然后可以通过调用selector的selectedKeys()方法，访问“已选择键集（selected key set）”中的就绪通道。
                 *
                 * 当像Selector注册Channel时，Channel.register()方法会返回一个SelectionKey 对象。
                 * 这个对象代表了注册到该Selector的通道。可以通过SelectionKey的selectedKeySet()方法访问这些对象。
                 */
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()) {
                        // do something
                    } else if (key.isConnectable()) {
                        // do something
                    } else if (key.isReadable()) {
                        // do something
                    } else if (key.isWritable()) {
                        // do something
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
