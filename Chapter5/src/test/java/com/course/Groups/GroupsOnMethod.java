package com.course.Groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void serverMethod1(){
        System.out.println("服务端方法1111111");
    }

    @Test(groups = "server")
    public void serverMethod2(){
        System.out.println("服务端方法22222222");
    }

    @Test(groups = "client")
    public void clientMethod3(){
        System.out.println("客户端方法3333333333");
    }

    @Test(groups = "client")
    public void clientMethod4(){
        System.out.println("客户端方法444444444");
    }

    @BeforeGroups("server")
    public void beforeGroups(){
        System.out.println("服务端组beforeGroups执行");
    }

    @AfterGroups("server")
    public void afterGroups(){
        System.out.println("服务端组afterGroups执行");
    }

    @BeforeGroups("client")
    public void clientBeforeGroups(){
        System.out.println("客户端组beforeGroups执行");
    }
    @AfterGroups("client")
    public void clientAfterGroups(){
        System.out.println("客户端组afterGroups执行");
    }
}
