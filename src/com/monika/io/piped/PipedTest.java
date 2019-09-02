package com.monika.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author XueYing.Cao
 * @date 2019/9/2
 * 线程内部通信(管道)
 * 管道流：PipedInputStream/PipedReader、PipedOutputStream/PipedWriter
 */
public class PipedTest {

    public static void main(String[] args) {
        //1. 创建管道输出流
        PipedSend send = new PipedSend();
        //2. 创建管道输入流
        PipedRecv recv = new PipedRecv();
        //3.将管道流相关联
        try {
            send.pos.connect(recv.pis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.启动线程，开始管道传输
        new Thread(send).start();
        new Thread(recv).start();
    }

    //管道输出流（发送方）
    private static class PipedSend implements Runnable {
        PipedOutputStream pos;
        public PipedSend() {
            pos = new PipedOutputStream();
        }

        @Override
        public void run() {
            //向管道发送数据
            try {
                byte[] bytes = "hello world! hello world!".getBytes();
                pos.write(bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //管道输入流（接收方）
    private static class PipedRecv implements Runnable {
        PipedInputStream pis;
        public PipedRecv() {
            pis = new PipedInputStream();
        }

        @Override
        public void run() {
            //从管道中接收数据
            try {
                int c;
                while((c = pis.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
