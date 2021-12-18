package cn.monitor4all.logrecordwebdemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "logRecord")
@ConditionalOnProperty(name = "listener.type", havingValue = "rabbitMq")
public class RabbitMqRecevier {

    private RabbitMqRecevier() {
        log.info("RabbitMqRecevier init");
    }

    @RabbitHandler
    public void receiveMessage(String message) {
        log.info("RabbitMqRecevier receiveMessage [{}]", message);
    }
}
