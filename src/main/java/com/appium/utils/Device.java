package com.appium.utils;

public enum Device {
    Redmi_8("3c7eb8", "12", "XiaomiNote8", "Android","uiAutomator2"),
    Pixel_2("emulator-5554", "11", "Pixel_2", "Android","uiAutomator2");

    public final String udid;
    public final String version;
    public final String deviceName;
    public final String platformName;
    public final String automationName;

    Device(String udid, String version, String deviceName, String platformName, String automationName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.automationName = automationName;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
