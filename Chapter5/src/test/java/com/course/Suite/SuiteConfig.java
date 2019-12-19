package com.course.Suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    // BeforeTest 只在套件内每一个类运行之前运行  AfterTest只在套件内每一个类运行之后运行
    // 并不是套件内 每个类含有@Test 注解的都会运行
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite 运行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest 运行了");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest 运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite 运行了");
    }
}
