package com.course.Groups;

import org.testng.annotations.Test;

@Test(groups = "Student")
public class GroupsOnClass2 {
    public void stu1(){
        System.out.println("我是Class2中的stu1");
    }
    public void sru2(){
        System.out.println("我是Class2中的stu2");
    }
}
