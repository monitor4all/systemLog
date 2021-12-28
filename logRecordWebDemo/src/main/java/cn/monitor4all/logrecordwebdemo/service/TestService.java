package cn.monitor4all.logrecordwebdemo.service;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.monitor4all.logrecordwebdemo.domain.TestClass;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @OperationLog(bizId = "#testClass.testStr", bizType = "testType1", msg = "#testClass")
    @OperationLog(bizId = "#isSuccess", bizType = "testType2", msg = "#testClass")
    public String testService(TestClass testClass, boolean isSuccess) throws Exception {
        if (isSuccess) {
            return testClass.toString();
        } else {
            throw new Exception("testError");
        }
    }
}
