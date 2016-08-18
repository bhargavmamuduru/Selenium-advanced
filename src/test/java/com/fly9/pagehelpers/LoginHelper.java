package com.fly9.pagehelpers;

import com.fly9.locators.LoginLocator;
import com.fly9.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static com.fly9.locators.LoginLocator.*;

/**
 * Created by Balu on 7/13/2016.
 */
public class LoginHelper extends  DriverHelper{

    public  LoginHelper(WebDriver driver)
    {
        super(driver);
    }



    public void enterEmail(String email)
    {

        WaitForElementPresent(EMAIL, 10);
        sendKeys(EMAIL, email);
    }

    public void enterPassword(String pass)
    {
        sendKeys(PASSWORD, pass);
    }
    public void clickLogin()
    {
        clickOn(LOGIN);
        waitForLoad(2000);
    }




}
