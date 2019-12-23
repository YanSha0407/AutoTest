package com.test.extend;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test1(){
         Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaa","bbbb");
    }
    @Test
    public void test4(){
        Reporter.log("我自己的运行时异常方法");
        throw new RuntimeException();
    }
}
