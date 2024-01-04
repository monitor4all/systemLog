package cn.monitor4all.logrecordspringboot3.function;


import cn.monitor4all.logRecord.annotation.LogRecordFunc;
import cn.monitor4all.logrecordspringboot3.service.TestService;
import cn.monitor4all.logrecordspringboot3.util.SpringContextUtils;

/**
 * SpEL自定义函数
 */
@LogRecordFunc(value = "CustomFunctionClass")
public class CustomFunctionClass {

    private static TestService testService;

    @LogRecordFunc
    public static String customFunction(String str) {
        if (testService == null) {
            testService = SpringContextUtils.getBean(TestService.class);
        }
        return testService.testServiceFunc2(str);
    }
}
