package com.monika.rabbitmq.publish_subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author XueYing.Cao
 * @date 2019/7/16
 * 发布者
 */
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static final String MESSAGE = "info: Hello World!";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            channel.basicPublish(EXCHANGE_NAME, "",
                    null, MESSAGE.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + MESSAGE + "'");
        }
    }
}
