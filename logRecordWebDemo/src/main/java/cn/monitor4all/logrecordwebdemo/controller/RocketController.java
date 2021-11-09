package cn.monitor4all.logrecordwebdemo.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/rocketMq")
public class RocketController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendMsg")
    public String rocketSend() {
        LocalDateTime currentTime = LocalDateTime.now();
        rocketMQTemplate.convertAndSend("logrecord", currentTime.toString());
        return currentTime.toString();
    }
}
