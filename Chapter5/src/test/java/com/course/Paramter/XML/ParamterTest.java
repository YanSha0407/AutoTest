package com.course.Paramter.XML;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParamterTest {
    // 通过xml文件进行参数化
    // 需要注册参数的的key也就是@Parameters({"name1","age1"}) 必须和xml文件中的 保持一致
    // <parameter name="name1" value="张三"/>
    // <parameter name="age1" value="18"/>
    @Test
    @Parameters({"name1","age1"})
    public void testParam(String name,int age){
        System.out.println("name = " + name + ";    age=" + age);
    }
}
