package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id= "email")
    WebElement emailElement;

    @FindBy(name="password")
    WebElement passwordElement;

    @FindBy(id="SubmitLogin")
    WebElement signInButton;

    @FindBy(name="email_create")
    WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    WebElement createNewAcountBtn;

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public HomePage login(String text,String password){
        Action.type(emailElement,text);
        Action.type(passwordElement,password);
        Action.click(getDriver(),signInButton);
        return new HomePage();
    }

    public AccountCreationPage createNewAccount(String newEmail){
        Action.type(emailForNewAccount,newEmail);
        return new AccountCreationPage();
    }

}
