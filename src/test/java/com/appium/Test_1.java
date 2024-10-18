package com.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_1 {
    /**
     * {
     * "appium:udid": "emulator-5554",
     * "appium:version": "11",
     * "appium:deviceName": "Pixel_2",
     * "platformName": "Android",
     * "appium:realDevice": "false",
     * "appium:automationName": "uiAutomator2"
     * }
     * webDriver---driver-url
     * AppiumDriver---driver---cihaz----app
     */

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
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
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),capabilities);

        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        Thread.sleep(2000);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(2000);
        //driver.rotate(new DeviceRotation(0,0,90));
        driver.rotate(ScreenOrientation.PORTRAIT);
        Thread.sleep(2000);
        driver.quit();
    }

}
