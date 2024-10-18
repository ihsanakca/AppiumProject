package com.appium;

import com.appium.utils.App;
import com.appium.utils.Device;
import com.appium.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.appium.utils.App.*;
import static com.appium.utils.Device.Pixel_2;
import static com.appium.utils.Utils.*;


public class Test_8 {

    AndroidDriver driver;
    WebDriverWait wait;
    By lTamamBtn = By.id("android:id/button1");
    By lScrollBars=By.xpath("//*[@text='ScrollBars']");
    By lCalFinal=By.id("com.google.android.calculator:id/result_final");

    @BeforeTest
    public void beforeTest() {
        driver = openApp(Pixel_2, ApiDemos);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test1() {

        clickWithText("Continue");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");

        swipeV(.9,.3);
        swipeV(.9,.3);
        swipeV(.2,.8);

        Utils.clickToCoordinate(146,1293);  //layouts
        swipeV(.9,.3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lScrollBars));
        Utils.clickToCoordinate(157,1052);  //scrollview

        List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
        for (WebElement e : elements){
            System.out.println(e.getText());
        }

        Assert.assertEquals(elements.size(), 25);

    }

    @Test
    public void test2() {

        clickWithText("Continue");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");

        swipeV(.9,.3);
        swipeV(.9,.3);
        swipeV(.2,.8);

        Utils.clickToCoordinate(146,1293);  //layouts
        swipeV(.9,.3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lScrollBars));
        Utils.clickToCoordinate(157,1052);  //scrollview

        List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
        for (WebElement e : elements){
            System.out.println(e.getText());
        }


        Assert.assertTrue(elements.size() > 0);

        driver.quit();

        driver = Utils.openApp(Pixel_2, Calculator);

        Utils.clickToCoordinate(435,1063);  //8
        Utils.clickToCoordinate(932,1479);  //+
        Utils.clickToCoordinate(665,1056);  //9
        Utils.clickToCoordinate(953,1662);  //=

        String actualText = driver.findElement(lCalFinal).getText();
        Assert.assertEquals(actualText,"17");


    }

    @Test
    public void test3() throws InterruptedException {

        clickWithText("Continue");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lTamamBtn));

        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");

        swipeV(.9,.3);
        swipeV(.9,.3);
        swipeV(.2,.8);

        Utils.clickToCoordinate(146,1293);  //layouts
        swipeV(.9,.3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lScrollBars));
        Utils.clickToCoordinate(157,1052);  //scrollview

        List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
        for (WebElement e : elements){
            System.out.println(e.getText());
        }


        Assert.assertTrue(elements.size() > 0);

      //  driver.quit();  // kapatırsak hata veriyor. app not running oluyor status.

        driver = Utils.openApp(Pixel_2, Calculator);

        Utils.clickToCoordinate(435,1063);  //8
        Utils.clickToCoordinate(932,1479);  //+
        Utils.clickToCoordinate(665,1056);  //9
        Utils.clickToCoordinate(953,1662);  //=

        System.out.println("driver.getCurrentPackage() = " + driver.getCurrentPackage());

        String actualText = driver.findElement(lCalFinal).getText();
        Assert.assertEquals(actualText,"17");


        activateBackgroundApp(ApiDemos.appPackage);
        driver.navigate().back();

        System.out.println("driver.getCurrentPackage() = " + driver.getCurrentPackage());


    }


    @AfterTest
    public void afterTest() {

        closeAllApps(new ArrayList<>(List.of(ApiDemos.appPackage,Calculator.appPackage)));
        System.out.println("bbb");
    }
}
