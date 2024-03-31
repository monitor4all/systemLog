package cn.monitor4all.logrecordwebdemo.domain;

import cn.monitor4all.logRecord.annotation.LogRecordDiffObject;
import lombok.Data;

import java.util.List;

@Data
@LogRecordDiffObject
public class TestClass {

    private Long testId;
    private String testStr;
    private List<String> testList;

}
