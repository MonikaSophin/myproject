package com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description:
 */
class NIOBlocked implements Runnable {
    private final SocketChannel sc;
    public NIOBlocked(SocketChannel sc) { this.sc = sc; }
    @Override
    public void run() {
        try {
            print("Waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            print("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            print("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        print("Exiting NIOBlocked.run() " + this);
    }
}

public class NIOInterruption {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(10000);
        InetSocketAddress isa = new InetSocketAddress("localhost", 10000);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);

        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        exec.shutdown();

        TimeUnit.SECONDS.sleep(1);
        //通过取消产生中断
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        //通过关闭通道释放块
        sc2.close();
    }
}
/**output(Sample):
 * Waiting for read() in com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3.NIOBlocked@1bc5ece8
 * Waiting for read() in com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3.NIOBlocked@4768105a
 * ClosedByInterruptException
 * Exiting NIOBlocked.run() com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3.NIOBlocked@1bc5ece8
 * AsynchronousCloseException
 * Exiting NIOBlocked.run() com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3.NIOBlocked@4768105a
 */