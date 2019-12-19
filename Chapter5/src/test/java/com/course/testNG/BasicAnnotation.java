package com.course.testNG;

import org.testng.annotations.*;
//import org.junit.Test;

public class BasicAnnotation {
    // Suite 中可以包含多个Class 也就是可以包含 多个类
    @BeforeSuite  // 测试套件
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("这是在类执行之前打印的");
    }
    @BeforeMethod
    public void beforeMethod(){
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
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
