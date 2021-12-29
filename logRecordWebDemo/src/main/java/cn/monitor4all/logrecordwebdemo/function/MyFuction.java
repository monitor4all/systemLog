package cn.monitor4all.logrecordwebdemo.function;


import cn.monitor4all.logRecord.function.LogRecordFunc;
import cn.monitor4all.logrecordwebdemo.service.TestService;
import cn.monitor4all.logrecordwebdemo.util.SpringContextUtils;

/**
 * SpEL自定义函数
 */
@LogRecordFunc
public class MyFuction {

    private static TestService testService;

    @LogRecordFunc
    public static String testFunc(String str) {
        if (testService == null) {
            testService = SpringContextUtils.getBean(TestService.class);
        }
        return testService.testServiceFunc2(str);
    }
}
