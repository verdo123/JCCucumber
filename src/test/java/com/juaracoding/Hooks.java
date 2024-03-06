package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    static WebDriver driver;

    @Before
    public static void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
    }


    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}
