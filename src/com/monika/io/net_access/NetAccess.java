package com.monika.io.net_access;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XueYing.Cao
 * @date 2019/9/2
 * 类的作用：网络访问
 * Socket编程：InputStream、OutputStream、Socket、ServerSocket、HttpURLConnection etc.
 */
public class NetAccess {

    public static void main(String[] args) {
        // 分配一个单独的线程给服务端
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            try (
                    //创建一个ServerSocket在端口12345监听客户请求
                    ServerSocket serverSocket = new ServerSocket(12345);

                    //使用accept() 阻塞并等待客户端请求，有客户端请求进来则获取一个Socket对象
                    Socket accept = serverSocket.accept();
                    InputStream in = accept.getInputStream();
                    OutputStream out = accept.getOutputStream()
            ) {
                //利用InputStream读取客户端请求的数据
                int c;
                while ((c = in.read()) != -1) {
                    System.out.print((char) c);
                }

//                //利用OutputStream向客户端发送数据
//                out.write("ok client!".getBytes());
//                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 主线程运行客户端
        try (
                //向本机12345端口发起连接请求
                Socket socket = new Socket("localhost", 12345);
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream()
        ) {
            //利用OutputStream向服务端发送数据
            out.write("hello Server!".getBytes());
            out.flush();

            //利用InputStream读取服务端响应的数据
//            int c;
//            while ((c = in.read()) != -1) {
//                System.out.print((char) c);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
