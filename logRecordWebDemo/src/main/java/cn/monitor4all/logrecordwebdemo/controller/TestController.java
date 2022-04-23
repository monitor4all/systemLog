package cn.monitor4all.logrecordwebdemo.controller;

import cn.monitor4all.logrecordwebdemo.domain.TestClass;
import cn.monitor4all.logrecordwebdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/logrecord")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/testSuccess")
    public String testSuccess() throws Exception {
        TestClass testClass = new TestClass();
        testClass.setTestId(1L);
        testClass.setTestStr("str");
        testClass.setTestList(Arrays.asList("1","2","3"));
        return testService.testServiceFunc1(testClass, true);
    }

    @GetMapping("/testFailure")
    public String testFailure() throws Exception {
        TestClass testClass = new TestClass();
        testClass.setTestId(2L);
        testClass.setTestStr("str");
        testClass.setTestList(Arrays.asList("1","2","3"));
        return testService.testServiceFunc1(testClass, false);
    }

}
