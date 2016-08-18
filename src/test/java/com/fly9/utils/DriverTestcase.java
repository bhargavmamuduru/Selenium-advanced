package com.fly9.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Balu on 7/14/2016.
 */
public abstract  class DriverTestcase {

    //Define objects
    private WebDriver driver;

    //Define variables
    protected String URL = ("https://www.facebook.com");
    protected static String Email = ("xxxxxxxxxxx");
    protected String Password = ("xxxxxxxxxx");

    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMainMethod()
    {
        driver.quit();
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}