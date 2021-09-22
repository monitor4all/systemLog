package cn.monitor4all.logRecord.service.impl;

import cn.monitor4all.logRecord.bean.LogDTO;
import cn.monitor4all.logRecord.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueueLogServiceImpl implements LogService {

    @Override
    public boolean createLog(LogDTO logDTO) {
        log.info("LogDTO [{}]", logDTO);
        // TODO 消息队列处理逻辑
        return true;
    }
}
