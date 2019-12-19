package com.course.Exception;

import org.testng.annotations.Test;

import java.util.EmptyStackException;

// 期望异常
public class ExceptException {
    @Test(expectedExceptions = RuntimeException.class)
    public void exceptExceptionTest1(){
        System.out.println("这是一个运行时异常");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void exceptExceptionTest2(){
        System.out.println("这是一个空指针异常");
        throw new NullPointerException();
    }
}
