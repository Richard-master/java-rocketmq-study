package com.yyh.my.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Description
 */
@Component
public class MyProducer<T> {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic,T message){
        rocketMQTemplate.convertAndSend(topic,message);
    }
}
