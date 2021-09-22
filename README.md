# RabbitMQ 五种常用模式

> 感兴趣的同学把代码下载到本地修改 src/main/resources/application.yml 文件和 src/test/resources/application.yml 中关于 RabbitMQ 服务器的一些配置项即可启动本项目。
> 关于 RabbitMQ 服务器的安装和一些基本的操作可以参照这篇博客【[RabbitMQ 启航篇](https://www.wrp.cool/posts/38923/)】，里面有 Linux 系统的详细安装步骤。
> 也欢迎大家关注我的博客【[知更博客](https://www.wrp.cool/)】。

## 简单模式

![简单模式数据流图](https://rabbitmq.com/img/tutorials/python-one.png)

## 工作线程模式

![工作线程模式数据流图](https://rabbitmq.com/img/tutorials/python-two.png)

> 工作线程模式中多个消费者监听同一个队列，当然每个消息还是只会被消费一次，不会被多次消费，起的是一种对消费者服务器的负载均衡作用。

## 发布/订阅模式

![发布/订阅模式数据流图](https://rabbitmq.com/img/tutorials/python-three.png)

> 发布/订阅模式可以比喻为广播，当生产者将消息投递到交换机中时，交换机会以广播的形式去广播给所有的队列，这样每个队列的消费者都会收到消息。

## 路由模式

![路由模式数据流图](https://rabbitmq.com/img/tutorials/python-four.png)

> 在路由模式之中，交换机与队列之间通过路由键绑定，生产者发布消息时必须指定对应的路由键，由对应路由键来消费此消息，若是没有指定路由键或是指定路由键错误则消费者无法收到消息。

## 通配符模式

![通配符模式数据流图](https://rabbitmq.com/img/tutorials/python-five.png)

> 通配符模式是路由模式的一种进阶，交换机与队列之间依然需要通过路由键绑定，但是这是一种规则的绑定。
> 生产者在投递消息的时候只要满足指定的规则交换机就会为其分配对应的队列，于是生产者在投递消息时只要满足对应的规则即可被多个消费者处理。
> 与路由模式最大的区别是：路由模式只能绑定一个定值，消费者每次投递的消息只能由一个对应的消费者来处理，但是通配符模式中只要满足规则可以由多个消费者处理。