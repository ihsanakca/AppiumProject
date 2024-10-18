package com.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.appium.utils.App.ApiDemos;
import static com.appium.utils.Device.Pixel_2;
import static com.appium.utils.Utils.closeApp;
import static com.appium.utils.Utils.openApp;

public class Test_6 {

    AndroidDriver driver;
    WebDriverWait wait;
    By lTamamBtn = By.id("android:id/button1");

    @BeforeTest
    public void beforeTest(){
        driver = openApp(Pixel_2, ApiDemos);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test1() {

        driver.findElement(By.xpath("//*[@text='Continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();

    }

    @AfterTest
    public void afterTest(){
        closeApp();
    }
}
