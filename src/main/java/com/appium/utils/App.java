package com.appium.utils;

public enum App {
    ApiDemos("com.touchboarder.android.api.demos", "com.touchboarder.androidapidemos.MainActivity"),
    Calculator("com.google.android.calculator", "com.android.calculator2.Calculator");

    public final String appPackage;
    public final String appActivity;

    App(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }
}
