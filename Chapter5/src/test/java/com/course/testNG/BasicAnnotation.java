package com.course.testNG;

import org.testng.annotations.*;
//import org.junit.Test;

public class BasicAnnotation {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("这是在类执行之前打印的");
    }
    @BeforeMethod
    public void boforeMethod(){
        System.out.println("这是在测试方法之前打印的");
    }
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    @AfterMethod
    public  void  afterMethod(){
        System.out.println("这是在测试方法之后打印的");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("这是在类执行之后打印的");
    }
}
