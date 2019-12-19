package com.course.Paramter.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void dataProviderTest(String name,int age){
        System.out.println("name = " + name + ";    age=" + age);
    }
    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][]{
                {"张三",20},
                {"李四",30},
                {"王五",40}
        };
    }
    @Test(dataProvider = "methodData")
    public void dataProviderTest1(String name,int age){
        System.out.println("dataProviderTest1");
        System.out.println("name = " + name + ";    age=" + age);
    }
    @Test(dataProvider = "methodData")
    public void dataProviderTest2(String name,int age){
        System.out.println("dataProviderTest2");
        System.out.println("name = " + name + ";    age=" + age);
    }
    @DataProvider(name = "methodData")
    public Object[][] methodData(Method method){
        Object[][] data = null;
        if (method.getName().equals("dataProviderTest1")){
            data = new Object[][]{
                    {"李雷",20},
                    {"韩梅梅",30}
            };
        }
        else if (method.getName().equals("dataProviderTest2")){
            data = new Object[][]{
                    {"Alisa",20},
                    {"Bob",30}
            };
        }
        return data;
    }
}