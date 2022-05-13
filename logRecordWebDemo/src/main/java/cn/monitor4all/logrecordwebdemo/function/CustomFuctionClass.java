package cn.monitor4all.logrecordwebdemo.function;


import cn.monitor4all.logRecord.annotation.LogRecordFunc;
import cn.monitor4all.logrecordwebdemo.service.TestService;
import cn.monitor4all.logrecordwebdemo.util.SpringContextUtils;

/**
 * SpEL自定义函数
 */
@LogRecordFunc("CustomFuctionClass")
public class CustomFuctionClass {

    private static TestService testService;

    @LogRecordFunc
    public static String customFunction(String str) {
        if (testService == null) {
            testService = SpringContextUtils.getBean(TestService.class);
        }
        return testService.testServiceFunc2(str);
    }
}
