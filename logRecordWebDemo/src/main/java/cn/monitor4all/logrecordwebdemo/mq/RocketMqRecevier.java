package cn.monitor4all.logrecordwebdemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "logrecordGroup", topic = "logrecord")
@ConditionalOnProperty(name = "listener.type", havingValue = "rocketMq")
public class RocketMqRecevier implements RocketMQListener<String> {

    private RocketMqRecevier() {
        log.info("RocketMqRecevier init");
    }


    @Override
    public void onMessage(String s) {
        log.info("RocketMqRecevier receive msg：[{}]", s);
    }

}
