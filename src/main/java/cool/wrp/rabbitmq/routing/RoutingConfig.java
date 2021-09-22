package cool.wrp.rabbitmq.routing;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由模式-配置类
 */
@Configuration
public class RoutingConfig {

    public static final String EXCHANGE_NAME = "direct_routing_exchange";

    public static final String INFO_AND_WARNING_QUEUE_NAME = "info_and_warning_routing_queue";
    public static final String ERROR_QUEUE_NAME = "error_routing_queue";

    public static final String ERROR_ROUTING_KEY = "error_log";
    public static final String INFO_ROUTING_KEY = "info_log";
    public static final String WARNING_ROUTING_KEY = "warning_log";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue infoAndWarningQueue() {
        return new Queue(INFO_AND_WARNING_QUEUE_NAME);
    }

    @Bean
    public Queue infoQueue() {
        return new Queue(ERROR_QUEUE_NAME);
    }

    @Bean
    public Binding bindInfoAndWarningQueueToDirectExchangeWithInfoKey() {
        return BindingBuilder.bind(infoAndWarningQueue()).to(directExchange()).with(INFO_ROUTING_KEY);
    }

    @Bean
    public Binding bindInfoAndWarningQueueToDirectExchangeWithWarningKey() {
        return BindingBuilder.bind(infoAndWarningQueue()).to(directExchange()).with(WARNING_ROUTING_KEY);
    }

    @Bean
    public Binding bindErrorQueueToDirectExchange() {
        return BindingBuilder.bind(infoQueue()).to(directExchange()).with(ERROR_ROUTING_KEY);
    }
}
