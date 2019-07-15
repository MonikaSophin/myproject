package com.monika.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author XueYing.Cao
 * @date 2019/7/15
 * rabbitmq 发送者
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        /**
         * 我们可以使用try-with-resources语句，因为Connection和Channel都实现了java.io.Closeable。
         * 这样我们就不需要在代码中明确地关闭它们。
         */
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent '" + message + "'");

        } catch (Exception e) {

        }
    }
}
