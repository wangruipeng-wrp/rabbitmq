package cool.wrp.rabbitmq.worker;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 工作线程模式-消费者
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerConsumer {

    @RabbitListener(queues = {WorkerConfig.QUEUE_NAME})
    public void consume1(String message) {
        System.out.println("【工作线程模式消费者1】接收到的消息是：" + message);
    }

    @RabbitListener(queues = {WorkerConfig.QUEUE_NAME})
    public void consume2(String message) {
        System.out.println("【工作线程模式消费者2】接收到的消息是：" + message);
    }
}
