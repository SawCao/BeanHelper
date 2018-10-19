package com.sawcao.beanoperation.tests.cloning.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/9/27
 **/
@Data
public class DeepCopyBean1 {
    private HashMap<String,HashMap<String,String>> testNestHash;
    private HashMap<String,String> testHash;
    private List<String> testList;
    private String testString;
    private Date testDate;
    private int testInt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date1;

    private Date date2;

    public DeepCopyBean1(){
        this.testString = "testString";
        this.testDate = new Date();
        this.testInt = 666;
    }

}
