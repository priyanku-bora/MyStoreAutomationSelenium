package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath="//*[@id=\"noSlide\"]/h1")
    WebElement formTitle;

    public AccountCreationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateAccountCreationPage(){
        return Action.isDisplayed(getDriver(),formTitle);
    }
}
