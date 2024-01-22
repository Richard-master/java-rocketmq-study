package com.yyh.my.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import sun.nio.ch.ThreadPool;
import sun.plugin2.message.Message;

import java.util.concurrent.*;

@SpringBootTest
class MyProducerApplicationTests {

    @Autowired
    MyProducer producer;

    @Test
    void contextLoads() {
    }

    @Test
    void testMessage() throws InterruptedException {
        String topic = "my-boot-topic";
        ExecutorService pool = new ThreadPoolExecutor(3,
                5,
                8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        while (true) {
            pool.execute(()->{
                Email email = new Email("张三", "yyhang@163.com", 1);
                producer.sendMessage(topic, email);
                System.out.println(Thread.currentThread().getName()+"消息发送成功");
            });
            Thread.sleep(5000);
        }
    }
}
