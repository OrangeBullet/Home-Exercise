package com.altruist.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        this.driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
