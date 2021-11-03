package cn.monitor4all.logrecordwebdemo.controller;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.monitor4all.logrecordwebdemo.domain.TestClass;
import cn.monitor4all.logrecordwebdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/testSuccess")
    public String testSuccess() throws Exception {
        TestClass testClass = new TestClass();
        testClass.setTestStr("str");
        testClass.setTestList(Arrays.asList("1","2","3"));
        return demoService.testService(testClass, true);
    }

    @GetMapping("/testFailure")
    public String testFailure() throws Exception {
        TestClass testClass = new TestClass();
        testClass.setTestStr("str");
        testClass.setTestList(Arrays.asList("1","2","3"));
        return demoService.testService(testClass, false);
    }

}
