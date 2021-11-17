package cn.monitor4all.logrecordwebdemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(name = "listener.type", havingValue = "rocketMq")
public class RocketMqRecevier {

    @Value("${rocketmq.consumer.name-server}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.group-name}")
    private String groupName;
    @Value("${rocketmq.consumer.topic}")
    private String topics;

    @Autowired
    private RocketMqMsgHandler mqMessageListenerProcessor;

    @Bean
    @ConditionalOnMissingBean
    public DefaultMQPushConsumer defaultMQPushConsumer() throws RuntimeException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.registerMessageListener(mqMessageListenerProcessor);

        try {
            // 设置该消费者订阅的主题和tag，如果是订阅该主题下的所有tag，使用*；
            consumer.subscribe(topics, "*");
            consumer.start();
            log.info("consumer is started. groupName [{}] topics [{}] namesrvAddr [{}]", groupName, topics, namesrvAddr);

        } catch (Exception e) {
            log.error("failed to start consumer. groupName [{}] topics [{}] namesrvAddr [{}]", groupName, topics, namesrvAddr,e);
            throw new RuntimeException(e);
        }
        return consumer;
    }

}
