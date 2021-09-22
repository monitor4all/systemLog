package cn.monitor4all.logrecordwebdemo.controller;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.monitor4all.logrecordwebdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/login")
    @OperationLog
    public String login() throws Exception {
        return demoService.login() ? "yes" : "no";
    }

}
