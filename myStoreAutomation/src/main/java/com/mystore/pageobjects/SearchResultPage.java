package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    @FindBy(xpath="//*[@id='center_column']/ul/li")
    WebElement productResult;

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span")
    WebElement addTocart;

    public SearchResultPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public Boolean validateProduct(){
       return Action.isDisplayed(getDriver(),productResult);
    }

    public void hoverOnElementAndclickAddtoCart(){
        Action.mouseHoverByJavaScript(productResult);
        Action.click(getDriver(),addTocart);
    }

    public AddToCartPage clickOnProduct(){
        Action.click(getDriver(),productResult);
        return new AddToCartPage();
    }

}
