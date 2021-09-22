package cn.monitor4all.logrecordwebdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.monitor4all.*")
public class LogRecordWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogRecordWebDemoApplication.class, args);
    }

}
