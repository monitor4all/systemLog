package cn.monitor4all.logrecordwebdemo.service;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.monitor4all.logRecord.context.LogRecordContext;
import cn.monitor4all.logrecordwebdemo.domain.TestClass;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    /**
     * 测试OperationLog
     */
    @OperationLog(bizId = "#testClass.testId", bizType = "'testType1'", msg = "#CustomFunctionClass_customFunction(#testClass.testId)")
    @OperationLog(bizId = "#testClass.testId", bizType = "'testType2'", msg = "#CustomFunctionService_customFunction(#testClass.testId)")
    @OperationLog(bizId = "#testClass.testId", bizType = "'testType3'", msg = "'单纯的字符串'")
    @OperationLog(bizId = "#testClass.testId", bizType = "'testType4'", msg = "'用户将旧值' + #old + '更改为新值' + #testClass.testStr")
    public String testServiceFunc1(TestClass testClass, boolean isSuccess) throws Exception {
        LogRecordContext.putVariable("old", "oldValue");
        if (isSuccess) {
            return testClass.toString();
        } else {
            throw new Exception("testError");
        }
    }

    /**
     * 测试自定义函数
     * @param str
     * @return
     */
    public String testServiceFunc2(String str) {
        return "testFunc:" + str;
    }
}
