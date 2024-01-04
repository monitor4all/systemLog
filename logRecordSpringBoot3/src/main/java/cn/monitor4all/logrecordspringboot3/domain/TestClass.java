package cn.monitor4all.logrecordspringboot3.domain;

import lombok.Data;

import java.util.List;

@Data
public class TestClass {

    private Long testId;
    private String testStr;
    private List<String> testList;

}
