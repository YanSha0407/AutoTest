package com.course.Ignore;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest {
    @Ignore
    public void IgnoreTest1(){
        System.out.println("IgnoreTest1 执行");
    }
    @Test
    public void IgnoreTest2(){
        System.out.println("IgnoreTest2 执行");
    }
    @Test(enabled = false) //测试用例不可用
    public void IgnoreTest3(){
        System.out.println("IgnoreTest3 执行");
    }

    @Test(enabled = true) //测试用例默认可用
    public void IgnoreTest4(){
        System.out.println("IgnoreTest4 执行");
    }
}
