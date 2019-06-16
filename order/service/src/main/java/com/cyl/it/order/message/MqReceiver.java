package com.cyl.it.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-29
 */
@Component
@Slf4j
public class MqReceiver {

    // 1.这个需要手动创建队列  在RabbitMQ的管理页面去创
    // @RabbitListener(queues = "myQueue")
    //2.自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3 自动创建，exchange 与queue 绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String msg) {
        log.info("消费者：<<<<===MqReceiver===>>>myQueue:{}",msg);
    }

    /**
     * @author chengyuanliang
     * @since 2019/5/29 21:13
     * @desc   数码供应商接收消息
     * @param  [msg]
     * @return void
     **/
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String msg) {
        log.info("消费者：<<<<===computer&&MqReceiver===>>>myQueue:{}",msg);
    }


    /**
     * @author chengyuanliang
     * @since 2019/5/29 21:13
     * @desc   数码供应商接收消息
     * @param  [msg]
     * @return void
     **/
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String msg) {
        log.info("消费者：<<<<===fruit&&MqReceiver===>>>myQueue:{}",msg);
    }

}




















