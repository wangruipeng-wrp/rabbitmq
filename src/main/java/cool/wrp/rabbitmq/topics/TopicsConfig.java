package cool.wrp.rabbitmq.topics;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicsConfig {

    public static final String EXCHANGE_NAME = "topics_exchange";

    public static final String QUEUE_1_NAME = "topics_queue_1";
    public static final String QUEUE_2_NAME = "topics_queue_2";
    public static final String QUEUE_3_NAME = "topics_queue_3";

    public static final String ORANGE_KEY = "*.orange.*";
    public static final String RABBIT_KEY = "*.*.rabbit";
    public static final String LAZY_KEY = "lazy.#";

    // Topics模式路由键规则：每个”。“代表一级，”*“号代表有且仅有一级，”#“号代表零级、一级或多级。

    @Bean
    public TopicExchange topicsExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue topicsQueue1() {
        return new Queue(QUEUE_1_NAME);
    }

    @Bean
    public Queue topicsQueue2() {
        return new Queue(QUEUE_2_NAME);
    }

    @Bean
    public Queue topicsQueue3() {
        return new Queue(QUEUE_3_NAME);
    }

    @Bean
    public Binding bindQueue1ToDirectTopicsExchangeWithOrange() {
        return BindingBuilder.bind(topicsQueue1()).to(topicsExchange()).with("*.orange.*");
    }

    @Bean
    public Binding bindQueue2ToDirectTopicsExchangeWithRabbit() {
        return BindingBuilder.bind(topicsQueue2()).to(topicsExchange()).with("*.*.rabbit");
    }

    @Bean
    public Binding bindQueue2ToDirectTopicsExchangeWithLazy() {
        return BindingBuilder.bind(topicsQueue3()).to(topicsExchange()).with("lazy.#");
    }
}
