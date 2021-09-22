package cool.wrp.rabbitmq.publishSubscribe;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布/订阅模式-配置类
 */
@Configuration
public class PublishSubscribeConfig {

    public static final String EXCHANGE_NAME = "fanout_publish_and_subscribe_exchange";
    public static final String QUEUE_1_NAME = "publish_and_subscribe_queue_1";
    public static final String QUEUE_2_NAME = "publish_and_subscribe_queue_2";

    @Bean
    public FanoutExchange fanoutPublishSubscribeExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue publishSubscribeQueue1() {
        return new Queue(QUEUE_1_NAME);
    }

    @Bean
    public Queue publishSubscribeQueue2() {
        return new Queue(QUEUE_2_NAME);
    }

    @Bean
    public Binding bindQueue1ToFanoutExchange() {
        return BindingBuilder.bind(publishSubscribeQueue1()).to(fanoutPublishSubscribeExchange());
    }

    @Bean
    public Binding bindQueue2ToFanoutExchange() {
        return BindingBuilder.bind(publishSubscribeQueue2()).to(fanoutPublishSubscribeExchange());
    }
}
