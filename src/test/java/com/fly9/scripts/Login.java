package com.fly9.scripts;

import com.fly9.pagehelpers.LoginHelper;
import com.fly9.utils.DriverTestcase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by Balu on 7/13/2016.
 */
public class Login extends DriverTestcase {


    @Test
    public void LoginTest(){

        LoginHelper loginHelper= new LoginHelper( getDriver() );

        // Open the application
        getDriver().navigate().to(URL);


        //Enter the email
        loginHelper.enterEmail(Email);


        //Enter the password
        loginHelper.enterPassword(Password);


        //Click on Login
        loginHelper.clickLogin();



    }


}
