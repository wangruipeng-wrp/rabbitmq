package cool.wrp.rabbitmq.publishSubscribe;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发布/订阅模式-消费者
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishSubscribeConsumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {PublishSubscribeConfig.QUEUE_1_NAME})
    public void consume1(String message) {
        System.out.println("【发布/订阅模式的消费者1】接收到的消息是：" + message);
    }

    @RabbitListener(queues = {PublishSubscribeConfig.QUEUE_2_NAME})
    public void consume2(String message) {
        System.out.println("【发布/订阅模式的消费者2】接收到的消息是：" + message);
    }
}
