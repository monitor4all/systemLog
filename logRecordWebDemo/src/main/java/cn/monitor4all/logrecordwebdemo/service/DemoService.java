package cn.monitor4all.logrecordwebdemo.service;

import cn.monitor4all.logRecord.annotation.DataPipelineEnum;
import cn.monitor4all.logRecord.annotation.OperationLog;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    /**
     * 模拟登陆逻辑
     */
    @OperationLog(bizId = "123", bizType = "login", pipeline = DataPipelineEnum.QUEUE)
    public boolean login() throws Exception {
        throw new Exception();
    }
}
