package cool.wrp.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 消息生产者
 */
public class Producer {

    public static void main(String[] args) {

        Connection connection = null;
        Channel channel = null;

        try {
            connection = RabbitMQCommon.getConnection();

            // 获取信道
            channel = connection.createChannel();

            /*
             * 声明队列存储消息
             *
             * @params1: 队列的名称
             * @params2: 队列是否持久化
             * @params3: 是否私有，如果为true，会对当前队列加锁，其他通道将不能访问
             * @params4: 是否自动删除，当最后一个消费者断开链接之后是否自动删除消息
             * @params5: 设置队列附属参数，
             */
            channel.queueDeclare("queue", false, false, false, null);

            /*
             * 发送消息给RabbitMQ中间件
             *
             * @params1: 交换机
             * @params2: 队列名称
             * @params3: 属性配置
             * @params4: 发送消息的内容
             */
            channel.basicPublish("", "queue", null, "Hello World！：）".getBytes(StandardCharsets.UTF_8));

            System.out.println("消息发送完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            RabbitMQCommon.close(connection, channel);
        }
    }
}
