package com.fly9.utils;

import com.fly9.locators.LoginLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Created by Balu on 7/13/2016.
 */
public abstract class DriverHelper {

    //Define objects
    private WebDriver driver;

    //Declare objects
    public DriverHelper(WebDriver webdriver)
    {
        driver = webdriver;
    }

    //Return web driver object
    public WebDriver getWebDriver()
    {
        return driver;
    }

    //Handle locator type
    public By ByLocator(String locator)
    {
        By result = null;

        if (locator.startsWith("//"))
        { result = By.xpath(locator); }
        else if (locator.startsWith("css="))
        { result = By.cssSelector(locator.replace("css=", "")); }
        else if (locator.startsWith("name="))
        { result = By.name(locator.replace("name=", ""));
        } else if (locator.startsWith("link="))
        { result = By.linkText(locator.replace("link=", "")); }
        else
        { result = By.id(locator); }
        return result;

    }
    //Wait for element present
    public void WaitForElementPresent(String locator, int timeout)
    {
        int i = 0;
        for (; i < timeout; i++)
        {
            if (isElementPresent(locator)) break;
            try
            { Thread.sleep(1000); }
            catch (InterruptedException e)
            { e.printStackTrace(); }
        }
        if (i == timeout) Assert.fail(locator + " is not present in given wait time.");
    }
    //Handle send keys action
    public void sendKeys(String locator, String text)
    {
        try{
            WaitForElementPresent(locator, 10);
            WebElement el = getWebDriver().findElement(ByLocator(locator));
            el.clear();
            Thread.sleep(1000);
            el.sendKeys(text);
        } catch(Exception e) {e.printStackTrace();}
    }
    //Handle click action
    public void clickOn(String locator)
    {
        WaitForElementPresent(locator, 10);
        WebElement el = getWebDriver().findElement(ByLocator(locator));
        el.click();
    }
    // wait For Load
    public void waitForLoad(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Boolean isElementPresent(String locator)
    {
        Boolean result = false;
        try
        {
            getWebDriver().findElement(ByLocator(locator));
            result = true;
        }
        catch (Exception ex) { }
        return result;
    }



}
