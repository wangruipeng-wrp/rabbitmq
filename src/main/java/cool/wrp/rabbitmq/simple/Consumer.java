package cool.wrp.rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 消息生产者
 */
public class Consumer {

    public static void main(String[] args) {

        Connection connection = null;
        Channel channel = null;

        try {
            connection = RabbitMQCommon.getConnection();

            // 获取信道
            channel = connection.createChannel();

            DeliverCallback deliverCallback = (consumerTag, message) -> {
                System.out.println("接收到的消息：" + new String(message.getBody(), StandardCharsets.UTF_8));
            };
            CancelCallback cancelCallback = (consumerTag) -> {
                System.out.println("接收消息失败！");
            };

            /*
             * 接收消息
             *
             * @params1: 要接收消息的队列名称
             * @params2: 是否自动应答
             * @params3: 接收到消息的回调
             * @params4: 取消消息的回调
             */
            channel.basicConsume("queue", true, deliverCallback, cancelCallback);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            RabbitMQCommon.close(connection, channel);
        }
    }
}
