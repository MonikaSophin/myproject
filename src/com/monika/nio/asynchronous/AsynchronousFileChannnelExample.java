package com.monika.nio.asynchronous;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @author XueYing.Cao
 * @date 2019/10/16
 */
public class AsynchronousFileChannnelExample {

    public static void main(String[] args) {
        String fileInName = "D:/GithubRepository/myproject/src/com/monika/nio/asynchronous/test_in";
        Path path = Paths.get(fileInName);
        try (
                AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                        StandardOpenOption.READ, StandardOpenOption.WRITE)
        ) {
            // 1. 通过Future读数据
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            // AsynchronousFileChannel#read(@1, @2) ： 第一个参数是ByteBuffer，第二个参数是文件中要开始读取的字节位置。
            Future<Integer> operation = fileChannel.read(buffer, 0);
            // read()即使读取操作尚未完成， 该方法也会立即返回。通过调用isDone()方法Future返回的实例的方法，来检查读取操作何时完成read()。
            while (!operation.isDone()) ;

            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            System.out.println(new String(bytes));
            buffer.clear();

            // 2. 通过CompletionHandler读数据
            // read()即使读取操作尚未完成， 该方法也会立即返回。
            fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("result = " + result);

                    attachment.flip();
                    byte[] bytes = new byte[attachment.limit()];
                    attachment.get(bytes);
                    System.out.println(new String(bytes));
                    attachment.clear();
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println(exc);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/nio/asynchronous/test_out";
        // 请注意，此代码生效之前，文件必须已经存在。如果文件不存在，则该write() 方法将引发java.nio.file.NoSuchFileException。
        Path path1 = Paths.get(fileOutName);
        if (!Files.exists(path1)) {
            try {
                Files.createFile(path1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (
                AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path1, StandardOpenOption.WRITE)
        ) {
            // 1. 通过Future写入数据
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            buffer.put("AsynchronousFileChannel to ByteBuffer!".getBytes());

            buffer.flip();
            Future<Integer> write = fileChannel.write(buffer, 0);
            while (!write.isDone());
            System.out.println("Write Done!");

            // 2. 通过CompletionHandler写入数据
            buffer.clear();
            buffer.put("write to buffer!".getBytes());

            buffer.flip();
            fileChannel.write(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("result = " + result);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("Write failed");
                    exc.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
