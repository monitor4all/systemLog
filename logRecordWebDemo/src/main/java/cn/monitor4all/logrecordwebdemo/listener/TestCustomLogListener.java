package cn.monitor4all.logrecordwebdemo.listener;

import cn.monitor4all.logRecord.bean.LogDTO;
import cn.monitor4all.logRecord.service.IOperationLogGetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 继承CustomLogListener类，可直接获取logDTO日志，不依赖于配置数据管道
 */
@Slf4j
@Component
public class TestCustomLogListener implements IOperationLogGetService {

    @Override
    public boolean createLog(LogDTO logDTO) {
        log.info("TestCustomLogListener 本地接收到日志 [{}]", logDTO);
        return true;
    }
}
