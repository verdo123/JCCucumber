package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

    public WebDriver setStrategy() {
        String path = "C:\\Users\\Personal\\IdeaProjects\\UjianMingguKe3.5\\geckodriver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",path);
        return new FirefoxDriver();
    }
}
