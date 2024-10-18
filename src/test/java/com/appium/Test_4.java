package com.appium;


import com.appium.utils.Driver;
import com.appium.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.appium.utils.App.ApiDemos;
import static com.appium.utils.Device.Pixel_2;

public class Test_4 {

 AndroidDriver driver;

    @Test
    public void test1() throws InterruptedException {

        Driver.runAppiumService();


        driver = Driver.getDriver(Pixel_2, ApiDemos);


        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        driver.quit();
        Driver.stopAppiumService();
    }

    @Test
    public void test2() throws InterruptedException {

        Driver.runAppiumService();


        driver = Utils.openApp(Pixel_2,ApiDemos);


        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        driver.quit();
        Driver.stopAppiumService();
    }
}
