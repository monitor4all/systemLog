package cn.monitor4all.logrecordwebdemo.service;

import cn.monitor4all.logRecord.annotation.DataPipelineEnum;
import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.monitor4all.logrecordwebdemo.domain.TestClass;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @OperationLog(bizId = "#testClass.testStr", bizType = "testType", msg = "#testClass", pipeline = DataPipelineEnum.QUEUE)
    public String testService(TestClass testClass, boolean isSuccess) throws Exception {
        if (isSuccess) {
            return testClass.toString();
        } else {
            throw new Exception("testError");
        }
    }
}
