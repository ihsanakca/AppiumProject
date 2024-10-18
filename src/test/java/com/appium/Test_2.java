package com.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_2 {
    AppiumDriverLocalService service;

    @Test
    public void test1() throws InterruptedException {
        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                // .usingPort(4723)
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Pixel_2");
        capabilities.setCapability("appium:automationName", "uiAutomator2");   // yeni versiyonda mutlaka eklenmeli
        capabilities.setCapability("platformName", "Android");


        capabilities.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");

        //driverı ayarlayalım
        AndroidDriver driver;
        driver = new AndroidDriver(service.getUrl(),capabilities);

        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        driver.quit();
        service.stop();
    }
}
