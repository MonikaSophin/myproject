package com.monika.rabbitmq.working_queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author XueYing.Cao
 * @date 2019/7/15
 *  任务队列--
 *     任务类，发送信息
 */
public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static final String MESSAGE = "first message";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            /**
             * 将消息标记为持久性并不能完全保证消息不会丢失。虽然它告诉RabbitMQ将消息保存到磁盘，
             * 但是当RabbitMQ接受消息并且尚未保存消息时，仍然有一个短时间窗口。
             * 此外，RabbitMQ不会为每条消息执行fsync（2）- 它可能只是保存到缓存而不是真正写入磁盘。
             * 持久性保证不强，但对于我们简单的任务队列来说已经足够了。如果您需要更强的保证，那么您可以使用 发布者确认。
             */
            boolean durable = true;
            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    MESSAGE.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + MESSAGE + "'");
        }
    }

}
