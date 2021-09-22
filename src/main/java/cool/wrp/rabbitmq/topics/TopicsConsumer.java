package cool.wrp.rabbitmq.topics;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通配符模式-消费者
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TopicsConsumer {

    @RabbitListener(queues = (TopicsConfig.QUEUE_1_NAME))
    public void customer1(String message) {
        System.out.println("【通配符模式消费者1】接收到的消息是：" + message);
    }

    @RabbitListener(queues = (TopicsConfig.QUEUE_2_NAME))
    public void customer2(String message) {
        System.out.println("【通配符模式消费者2】接收到的消息是：" + message);
    }

    @RabbitListener(queues = (TopicsConfig.QUEUE_3_NAME))
    public void customer3(String message) {
        System.out.println("【通配符模式消费者3】接收到的消息是：" + message);
    }
}
