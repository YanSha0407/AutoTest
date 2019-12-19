package com.course.Depend;

import org.testng.annotations.Test;

// 方法依赖测试
public class DependTest {
    // test2  方法依赖于 test1 方法
    // 如果test1 方法执行失败 则test2方法会被忽略 不执行

    // test1 期望抛出一个运行时异常  实际没有抛出异常 则运行失败 test2 不执行
    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("执行test1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("执行test2");
    }

}
