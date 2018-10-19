package com.sawcao.beanoperation.tests.cloning.domain;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/9/27
 **/
@Data
public class DeepCopyBean2 {
    private HashMap<String,HashMap<String,String>> testNestHash;
    private HashMap<String,String> testHash;
    private String testString;
    private Date testDate;
    private int testInt;
    private int testInt1;

    public DeepCopyBean2(){
        this.testString = "testString";
        this.testDate = new Date();
        this.testInt = 666;
    }

}
