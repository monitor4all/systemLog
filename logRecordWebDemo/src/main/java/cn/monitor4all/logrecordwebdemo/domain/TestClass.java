package cn.monitor4all.logrecordwebdemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class TestClass {

    private Long testId;
    private String testStr;
    private List<String> testList;

}
