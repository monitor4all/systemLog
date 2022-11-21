package cn.monitor4all.logrecordwebdemo.config;

import cn.monitor4all.logRecord.bean.LogDTO;
import cn.monitor4all.logRecord.thread.LogRecordThreadWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class LogRecordConfig {

    @Bean
    public LogRecordThreadWrapper logRecordThreadWrapper() {
        return new LogRecordThreadWrapper() {
            @Override
            public Runnable createLog(Consumer<LogDTO> consumer, LogDTO logDTO) {
                log.info("Before send createLog task to LogRecordThreadPool. Current thread [{}]", Thread.currentThread().getName());
                return LogRecordThreadWrapper.super.createLog(consumer, logDTO);
            }
        };
    }

}
