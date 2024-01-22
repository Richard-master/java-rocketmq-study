package com.yyh.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * @Classname
 * @Description
 */
@Component
// 监听哪个topic
@RocketMQMessageListener(consumerGroup = "my-boot-consumer-group1",topic = "my-boot-topic")
public class MyConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        Email email = JSONObject.parseObject(s, Email.class);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("收到的消息："+email);
    }
}
