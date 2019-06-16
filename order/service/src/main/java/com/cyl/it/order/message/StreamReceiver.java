package com.cyl.it.order.message;

import com.cyl.it.order.co.CarCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    public void process(String msg){
        log.info("消费者====StreamReceiver====myMessage:{}", msg);
    }

     /**
     * @since 2019/5/30 16:07
     * @desc   接收对象  可在application.yml中配置样式:content-type
     * @param  [msg]
     * @return void
     */
    @StreamListener(value=StreamClient.OBJECT)
    public void processObject(CarCO msg){
        log.info("消费者====StreamReceiverObject====myObject:{}", msg);
    }


    @StreamListener(value = StreamClient.SEND)
    @SendTo(StreamClient.SENDTO)
    public String processSend(CarCO msg){
        log.info("消费者====StreamReceiverSend====reSend:{}", msg);
        return "received";
    }

    @StreamListener(value = StreamClient.SENDTO)
    public void processSendTo(String msg){
        log.info("消费者====StreamReceiverSend====reSendTo:{}", msg);

    }
}
