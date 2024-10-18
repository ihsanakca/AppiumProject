package com.appium;

import com.appium.utils.App;
import com.appium.utils.Device;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Test_3 {
    AppiumDriverLocalService service;
    Device device= Device.Pixel_2;
    App app=App.ApiDemos;

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
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("appium:automationName", device.automationName);   // yeni versiyonda mutlaka eklenmeli
        capabilities.setCapability("platformName", device.platformName);


        capabilities.setCapability("appium:appPackage", app.appPackage);
        capabilities.setCapability("appium:appActivity", app.appActivity);

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
