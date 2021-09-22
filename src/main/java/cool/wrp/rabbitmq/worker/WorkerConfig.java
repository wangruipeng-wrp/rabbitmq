package cool.wrp.rabbitmq.worker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工作线程模式-配置类
 */
@Configuration
public class WorkerConfig {

    public static final String QUEUE_NAME = "fanout_worker_queue";
    public static final String EXCHANGE_NAME = "fanout_worker_exchange";

    @Bean
    public Queue workerQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public FanoutExchange fanoutWorkerExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bind() {
        return BindingBuilder.bind(workerQueue()).to(fanoutWorkerExchange());
    }
}
