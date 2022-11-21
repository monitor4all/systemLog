package cn.monitor4all.logrecordwebdemo.function;


import cn.monitor4all.logRecord.annotation.LogRecordFunc;
import cn.monitor4all.logrecordwebdemo.service.TestService;
import cn.monitor4all.logrecordwebdemo.util.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@LogRecordFunc("CustomFunctionService")
public class CustomFunctionService {

    @Autowired
    private TestService testService;

    @LogRecordFunc
    public String customFunction(String str) {
        return testService.testServiceFunc2(str);
    }
}
