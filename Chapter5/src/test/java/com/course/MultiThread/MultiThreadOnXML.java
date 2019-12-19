package com.course.MultiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXML {
    @Test
    public void test1(){
        System.out.println("currentThread test1  ID ====" + Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.println("currentThread test2 ID ====" + Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.println("currentThread test3 ID ====" + Thread.currentThread().getId());
    }
}
