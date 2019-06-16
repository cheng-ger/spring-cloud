package com.cyl.it.order.controller;

import com.cyl.it.order.co.CarCO;
import com.cyl.it.order.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengyuanliang
 * @desc  主要用于测试rabbit中间消息件
 * @since 2019-05-29
 */
@Slf4j
@RestController
@RequestMapping("rabbitService")
public class MqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

    /*这个只尝试queue*/
    @RequestMapping("myQueue")
    public  String  send(@RequestParam String msg){
        log.info("生产者：<<<<===MqSender===>>>myQueue:{}",msg);
        amqpTemplate.convertAndSend("myQueue",msg);
        return msg;
    }


    @RequestMapping("myOrderComputer")
    public  String  sendMsgComputer(@RequestParam String msg){
        log.info("生产者：<<<<===myOrderComputer&&MqSender===>>>myQueue:{}",msg);
        amqpTemplate.convertAndSend("myOrder", "computer",msg);
        return msg;
    }

    @GetMapping("myOrderFruit")
    public  String  sendMsgFruit(@RequestParam String msg){
        log.info("生产者：<<<<===myOrderFruit&&MqSender===>>>myQueue:{}",msg);
        amqpTemplate.convertAndSend("myOrder", "fruit",msg);
        return msg;
    }

    @GetMapping("streamMyMessage")
    public  String  sendStreamClient(@RequestParam String msg){
        log.info("生产者：<<<<===sendStreamClient===>>>myMessage:{}",msg);

        streamClient.output().send(MessageBuilder.withPayload(msg).build());
        return msg;
    }

    @GetMapping("streamMyObject")
    public  CarCO  sendStreamClientObject(){
        CarCO carCO = new CarCO();
        carCO.setProductId(1l);
        carCO.setProductQuantity(100);
        log.info("生产者：<<<<===sendStreamClient===>>>myObject:{}",carCO);

        streamClient.outputObject().send(MessageBuilder.withPayload(carCO).build());
        return carCO;
    }

    @GetMapping("streamSend")
    public  CarCO  sendStreamClientObject2(){
        CarCO carCO = new CarCO();
        carCO.setProductId(110l);
        carCO.setProductQuantity(10);
        log.info("生产者：<<<<===sendStreamClient===>>>send:{}",carCO);

        streamClient.outputSend().send(MessageBuilder.withPayload(carCO).build());
        return carCO;
    }

}
