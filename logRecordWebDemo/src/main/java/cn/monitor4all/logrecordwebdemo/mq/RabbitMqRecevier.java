package cn.monitor4all.logrecordwebdemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "logrecord")
public class RabbitMqRecevier {

    @RabbitHandler
    public void receiveMessage(String message) {
        log.info("receiveMessage [{}]", message);
    }
}
