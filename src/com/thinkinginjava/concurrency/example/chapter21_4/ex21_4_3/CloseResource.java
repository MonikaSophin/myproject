package com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description:
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();

        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));

        TimeUnit.MILLISECONDS.sleep(100);
        print("Shutting down all threads");
        /**
         * 返回的是 从未开始执行的任务列表
         */
        List<Runnable> runnables = exec.shutdownNow();
        print(runnables);

        TimeUnit.SECONDS.sleep(1);
        print("Closing " + socketInput.getClass().getName());
        socketInput.close();

        TimeUnit.SECONDS.sleep(1);
        print("Closing " + System.in.getClass().getName());
        System.in.close();
    }
}
/**output(Sample):
 * Waiting for read()
 * Waiting for read()
 * Shutting down all threads
 * []
 * Closing java.net.SocketInputStream
 * Interrupted from blocked I/O
 * Exiting IOBlocked.run()
 *
 * Closing java.io.BufferedInputStream
 * Interrupted from blocked I/O
 * Exiting IOBlocked.run()
 */