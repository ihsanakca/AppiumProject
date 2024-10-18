package com.appium;

import com.appium.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.appium.utils.App.ApiDemos;
import static com.appium.utils.Device.Pixel_2;
import static com.appium.utils.Utils.*;

public class Test_7 {

    AndroidDriver driver;
    WebDriverWait wait;
    By lTamamBtn = By.id("android:id/button1");
    By lviews = By.xpath("//*[@text='Views']");
    By lwebView = By.xpath("//*[@text='WebView']");

    @BeforeTest
    public void beforeTest() {
        driver = openApp(Pixel_2, ApiDemos);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test1() {

        driver.findElement(By.xpath("//*[@text='Continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lviews)).click();

        swipeV(.6, .2);

        swipeUntil(lwebView, .6, .3);

    }

    @Test
    public void test2() {

        driver.findElement(By.xpath("//*[@text='Continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lviews)).click();


        swipeUntil(lwebView, .6, .3);

        driver.findElement(lwebView).click();

    }
    @Test
    public void test3() {

        driver.findElement(By.xpath("//*[@text='Continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lviews)).click();

        swipeAndClick(lwebView,.7,.2);

    }

    @AfterTest
    public void afterTest() {
        closeApp();
    }
}
