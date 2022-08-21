package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

    IndexPage indexPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        System.out.println("IndexPage Browser = "+browser);
        launchApp(browser);
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void verifyLogo(){
        Log.startTestCase("Login Test");
        indexPage = new IndexPage();
        Log.info("Validating Logo");
        boolean flag = indexPage.validateLogo();
        Assert.assertTrue(flag);
    }
}
