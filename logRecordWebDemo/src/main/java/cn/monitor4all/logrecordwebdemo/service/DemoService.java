package cn.monitor4all.logrecordwebdemo.service;

import cn.monitor4all.logRecord.annotation.OperationLog;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    /**
     * 模拟登陆逻辑
     */
    @OperationLog
    public boolean login() throws Exception {
        throw new Exception();
    }
}
