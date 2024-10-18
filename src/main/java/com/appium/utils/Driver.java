package com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    static AppiumDriverLocalService service;
    private static AndroidDriver driver;

    public static void runAppiumService(){
        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }
    public static void stopAppiumService(){
        service.stop();
    }

    public static AndroidDriver getDriver(Device device, App app){
        driver=new AndroidDriver(service.getUrl(),setCapabilities(device,app));
        return driver;
    }

    private static DesiredCapabilities setCapabilities(Device device, App app){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("appium:automationName", device.automationName);   // yeni versiyonda mutlaka eklenmeli
        capabilities.setCapability("platformName", device.platformName);

        capabilities.setCapability("appium:appPackage", app.appPackage);
        capabilities.setCapability("appium:appActivity", app.appActivity);

        return capabilities;
    }

    public static AndroidDriver getDriver(){
        return driver;
    }
}
