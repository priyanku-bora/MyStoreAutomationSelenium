package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.driver;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "//a[@class='login']")
    WebElement signInButton;

    @FindBy(xpath = "//img[@class=\"logo img-responsive\"]")
    WebElement myStoreLogo;

    @FindBy(id="search_query_top")
    WebElement searchBox;

    @FindBy(id="")
    WebElement searchButton;

    public IndexPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public LoginPage clickOnSignIn(){
        Action.click(getDriver(),signInButton);
        return new LoginPage();
    }

    public Boolean validateLogo(){
        return Action.isDisplayed(getDriver(),myStoreLogo);

    }

    public String getTitle(){
       String myStoreTitle =  Action.getTitle(getDriver());
       return myStoreTitle;
    }

    public SearchResultPage searchProduct(String productName){
        Action.type(searchBox,productName);
        Action.click(getDriver(),searchButton);
        return new SearchResultPage();
}
}
