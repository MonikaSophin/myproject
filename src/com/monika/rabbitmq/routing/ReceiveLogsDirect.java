package com.monika.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author XueYing.Cao
 * @date 2019/7/16
 * 订阅者
 */
public class ReceiveLogsDirect {
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();

        //可以订阅特定 routing key的信息。 例如：接受info、error 或 接受 warning、error 等组合。
        String[] routingKeys = new String[] { "info", "warning", "error" };
       // String[] routingKeys = new String[] { "warning", "error" };
       // String[] routingKeys = new String[] { "info", "warning"};
       // String[] routingKeys = new String[] { "info", "error" };
        for (String severity : routingKeys) {
            //使用routing key创建一个新的绑定。
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
        }
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" +
                    delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };

        boolean autoAck = true;
        channel.basicConsume(queueName, autoAck, deliverCallback, consumerTag -> { });
    }
}
