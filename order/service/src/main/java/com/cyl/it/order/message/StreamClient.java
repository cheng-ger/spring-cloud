package com.cyl.it.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */

public interface StreamClient {

    String INPUT = "myMessage";

    String OBJECT = "myObject";

    String SEND = "reSend";

    String SENDTO = "reSendTo";


    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();


    @Input(StreamClient.OBJECT)
    SubscribableChannel inputObject();

    @Output(StreamClient.OBJECT)
    MessageChannel outputObject();

    @Input(StreamClient.SEND)
    SubscribableChannel inputSend();

    @Output(StreamClient.SEND)
    MessageChannel outputSend();

    @Input(StreamClient.SENDTO)
    SubscribableChannel inputSendTo();

    @Output(StreamClient.SENDTO)
    MessageChannel outputSendTo();
}
