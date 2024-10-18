package com.appium.utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.appium.utils.Driver.*;

public class Utils {
    public static AndroidDriver openApp(Device device, App app) {
        runAppiumService();
        return getDriver(device, app);
    }

    public static void closeApp() {
        getDriver().quit();
        stopAppiumService();
    }
    public static void closeAllApps(List<String> appPackages) {
        for (String appPackage : appPackages) {
            getDriver().terminateApp(appPackage);
        }
    }


    public static void swipeV(double startPoint, double endPoint) {

        int width = Driver.getDriver().manage().window().getSize().width;
        int height = Driver.getDriver().manage().window().getSize().height;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
                width / 2, (int) (height * startPoint))); // start position
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())); // press action
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
                width / 2, (int) (height * endPoint))); // end position
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // release

        Driver.getDriver().perform(Arrays.asList(swipe)); // perform the swipe
    }

    public static void swipeUntil(By locator, double startPoint, double endPoint) {

        while (Driver.getDriver().findElements(locator).size() <= 0) {
            swipeV(startPoint, endPoint);
        }
    }

    public static void swipeAndClick(By locator, double startPoint, double endPoint) {

        while (Driver.getDriver().findElements(locator).size() <= 0) {
            swipeV(startPoint, endPoint);
        }
        Driver.getDriver().findElement(locator).click();
    }

    public static void clickWithText(String text) {
        Driver.getDriver().findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public static void clickToCoordinate(int x, int y) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y)); // move
        // to position
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())); // press down
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // release

        Driver.getDriver().perform(Arrays.asList(tap)); // perform the tap

    }

    public static void activateBackgroundApp(String appPackage) {
        ApplicationState applicationState = getDriver().queryAppState(appPackage);
        System.out.println(applicationState);

        // Uygulama arka planda mı çalışıyor veya başka bir durumda mı?
        if (applicationState == ApplicationState.RUNNING_IN_BACKGROUND ||
                applicationState == ApplicationState.RUNNING_IN_BACKGROUND_SUSPENDED) {

            // Biraz gecikme ekleyerek aktivasyonu bekleyin
            try {
                Thread.sleep(1000); // 1 saniye bekleyin
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            getDriver().activateApp(appPackage);
        } else {
            System.out.println("Uygulama zaten ön planda ya da geçersiz bir durumda.");
        }
    }

    }


