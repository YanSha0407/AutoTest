package com.course.timeOut;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void timeOutSuccess() throws InterruptedException {
         Thread.sleep(2000);
     }

    @Test(timeOut = 2000)
    public void timeOutFaild() throws InterruptedException {
        Thread.sleep(3000);
    }
}
