package cool.wrp.rabbitmq.routing;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 路由模式-消费者
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoutingConsumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {RoutingConfig.INFO_AND_WARNING_QUEUE_NAME})
    public void errorLogAndWarningLogConsume(String message) {
        System.out.println("【路由模式的消费者1】接收到的消息是：" + message);
    }

    @RabbitListener(queues = {RoutingConfig.ERROR_QUEUE_NAME})
    public void infoLogConsume(String message) {
        System.out.println("【路由模式的消费者2】接收到的消息是：" + message);
    }
}
