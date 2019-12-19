package com.course.Groups;

import org.testng.annotations.Test;

@Test(groups = "Student")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("我是Class1中的stu1");
    }
    public void sru2(){
        System.out.println("我是Class1中的stu2");
    }
}
