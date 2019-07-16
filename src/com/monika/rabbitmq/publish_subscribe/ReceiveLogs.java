package com.monika.rabbitmq.publish_subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author XueYing.Cao
 * @date 2019/7/16
 * 订阅者
 */
public class ReceiveLogs {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        /**
         * 由exchange分配的队列名称，是随机的
         * 例如:
         * amq.gen-SRQ0yDJwP0X4Ow_xFspY-A
         */
        String queueName = channel.queueDeclare().getQueue();
        System.out.println(" ----" + queueName);
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        boolean autoAck = true;
        channel.basicConsume(queueName, autoAck, deliverCallback, consumerTag -> { });
    }

}
