package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//*[@id='center_column']/div/div[2]/ul/li/a/span")
    WebElement myWishList;

    @FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
    WebElement orderHistoryAndDetails;

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateMyWishList(){
        return Action.isDisplayed(getDriver(),myWishList);
    }

    public boolean validateOrderHistory(){
        return Action.isDisplayed(getDriver(),orderHistoryAndDetails);
    }
}
